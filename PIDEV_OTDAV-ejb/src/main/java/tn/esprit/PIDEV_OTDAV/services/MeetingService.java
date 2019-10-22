package tn.esprit.PIDEV_OTDAV.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.PIDEV_OTDAV.entity.Disponibility;
import tn.esprit.PIDEV_OTDAV.entity.Meeting;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;


@Stateless
@LocalBean
public class MeetingService implements MeetingServiceRemote{
	
	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	private EntityManager em;
	
	private static Cipher ecipher;

    private static Cipher dcipher;

    private static SecretKey key;

	@Override
	public int addMeeting(Meeting m) {
		em.persist(m);
		return m.getId();
	}

	@Override
	public void modifyMeeting(Meeting m, int id) {

		m.setId(id);
		em.merge(m);
	}

	@Override
	public void CancelMeeting(int id) {
		
		Meeting m = em.find(Meeting.class,id);
		m.setIsNotCanceled(0);
		
	}

	@Override
	public Meeting findByUserId(int id) {
		
		TypedQuery<Meeting> q = em.createQuery(
		"select m from Meeting m where m.user_id=:id",
		Meeting.class	);
		
		q.setParameter("id", id);
		
		Meeting m = q.getSingleResult();
		
		return m;
	}

	@Override
	public List<Meeting> findByDate(Date date) {

		TypedQuery<Meeting> q = em.createQuery(
		"select m from Meeting m where m.date=:date",
		Meeting.class	);
		
		q.setParameter("date", date);
		
		List<Meeting> lm = q.getResultList();
		
		return lm;
	}

	@Override
	public void confirmMeeting(int id) {
		
		Meeting m = em.find(Meeting.class,id);
		m.setConfirmed(1);
		
	}

	@Override
	public String prepareQRCodeCore(int id) {
		
		String encrypted ;
		
		Meeting m = em.find(Meeting.class,id);
		
		
			if( (m.getEnabled() == 1) && (m.getIsNotCanceled()==1) ){
				m.setScanned(1);
			}
			
			String s = Integer.toString(id);
			
	        try {

	            // generate secret key using DES algorithm
	            key = KeyGenerator.getInstance("DES").generateKey();
	            ecipher = Cipher.getInstance("DES");
	            dcipher = Cipher.getInstance("DES");
	            // initialize the ciphers with the given key
	            
	            ecipher.init(Cipher.ENCRYPT_MODE, key);
	            dcipher.init(Cipher.DECRYPT_MODE, key);
	            
	            encrypted = encrypt(s);
	            //String decrypted = decrypt(encrypted);
	            
	        	}
	        
	        catch (NoSuchAlgorithmException e) {

	            System.out.println("No Such Algorithm:" + e.getMessage());

	            return null;

	        }

	        catch (NoSuchPaddingException e) {

	            System.out.println("No Such Padding:" + e.getMessage());

	            return null;

	        }

	        catch (InvalidKeyException e) {

	            System.out.println("Invalid Key:" + e.getMessage());

	            return null;

	        }
			
		return encrypted;
	}
	
    public static String encrypt(String str) {

    	try {

    		// encode the string into a sequence of bytes using the named charset
    		// storing the result into a new byte array.
    		byte[] utf8 = str.getBytes("UTF8");
    		byte[] enc = ecipher.doFinal(utf8);
    		// encode to base64
    		enc = BASE64EncoderStream.encode(enc);
    		return new String(enc);
    		}
    	catch (Exception e) {e.printStackTrace();}

 

    	return null;
    }
    
    public static String decrypt(String str) {

    	try {
    		
    		// decode with base64 to get bytes
    		byte[] dec = BASE64DecoderStream.decode(str.getBytes());
    		byte[] utf8 = dcipher.doFinal(dec);
    		// create new string based on the specified charset
    		return new String(utf8, "UTF8");
    		
    	   }catch (Exception e) {e.printStackTrace();}

    	return null;

    }
    
    // Ref : https://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-string-with-des/
    
    public void addDispo(Disponibility d){
    	em.persist(d);
    }
    
    public List<Disponibility> getAllDispo(){
    	
		TypedQuery<Disponibility> q = em.createQuery(
				"select d from Disponibility d",
				Disponibility.class
				);

		return q.getResultList();
    }
    
    public void ConfirmationMeeting(int id){
    	
		Query q =  em.createQuery("update Disponibility d set etat=:etat where d.id=:id");
		q.setParameter("id",id);
		q.setParameter("etat", "confirmé");
		q.executeUpdate();
    	
    }

	@Override
	public List<Disponibility> getFreeDispo() {
		
		TypedQuery<Disponibility> q = em.createQuery(
				"select d from Disponibility d where etat=:etat",
				Disponibility.class
				);
		q.setParameter("etat", "non reserve");

		return q.getResultList();
	}

	@Override
	public Disponibility updateDispo(int id, String prenom, String nom, String email,int id_user) {
		
		System.out.println("****************************"+id);
		
		Query q =  em.createQuery("update Disponibility d set etat=:etat,nom=:nom,prenom=:prenom,email=:email,id_user=:idu where d.id=:id");
		q.setParameter("id",id);
		q.setParameter("etat", "demendé");
		q.setParameter("nom", nom);
		q.setParameter("prenom", prenom);
		q.setParameter("email", email);
		q.setParameter("idu", id_user);
		q.executeUpdate();
		
		TypedQuery<Disponibility> q2 = em.createQuery(
				"select d from Disponibility d where d.id=:id",
				Disponibility.class
				);
		q2.setParameter("id",id);
		
		return q2.getSingleResult();

	}

	@Override
	public int verifExistUser(int id) {
		
		TypedQuery<Disponibility> q2 = em.createQuery(
				"select d from Disponibility d where d.id_user=:id",
				Disponibility.class
				);
		q2.setParameter("id",id);
		
		
		List results = q2.getResultList();
		
			if(results.isEmpty()){
				return 0;
			}
		
		
		return 1;
	}

	@Override
	public Disponibility findDispoByUserId(int id) {
		
		
		TypedQuery<Disponibility> q2 = em.createQuery(
				"select d from Disponibility d where d.id_user=:id",
				Disponibility.class
				);
		q2.setParameter("id",id);
		
		return q2.getSingleResult();
	}

	@Override
	public Meeting findMeetingByUserId(int id) {
		TypedQuery<Meeting> q2 = em.createQuery(
				"select m from Meeting m where m.id_user=:id",
				Meeting.class
				);
		q2.setParameter("id",id);
		
		return q2.getSingleResult();
	
	}

	@Override
	public void cancelDesponibility(int id) {
		Query q =  em.createQuery("update Disponibility d set etat=:etat where d.id=:id");
		q.setParameter("id",id);
		q.setParameter("etat", "demendé");
		q.executeUpdate();
		
	}

	@Override
	public void deleteDesponibility(int id) {
		
		
		Disponibility d = em.find(Disponibility.class,id);
		em.remove(d);
	
	}

}
