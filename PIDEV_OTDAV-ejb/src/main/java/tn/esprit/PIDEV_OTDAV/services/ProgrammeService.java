package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.plaf.synth.SynthSeparatorUI;

import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.ArtworkPoint;
import tn.esprit.PIDEV_OTDAV.entity.ArtworkPointId;
import tn.esprit.PIDEV_OTDAV.entity.Programme;
import tn.esprit.PIDEV_OTDAV.entity.User;

@Stateless
@LocalBean
public class ProgrammeService implements ProgrammeServiceRemote{

	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	EntityManager em ;

	@Override
	public List<Programme> all() {
		List<Programme> listProgramme=null;
		TypedQuery<Programme> query = em.createQuery("Select p from Programme p ", Programme.class);	
		try {
			listProgramme = query.getResultList();
		} catch (NoResultException e ) {
		}
		return listProgramme;
	}
	
	@Override
	public List<Programme> allByUser(User user) {
		System.out.println("user connected id :"+user.getId());
		List<Programme> listProgramme=null;
		TypedQuery<Programme> query = em.createQuery("Select p from Programme p where p.user.id="+user.getId(), Programme.class);	
		try {
			listProgramme = query.getResultList();
		} catch (NoResultException e ) {
		}
		return listProgramme;
	}

	@Override
	public Programme show(int id) {
		return em.find(Programme.class, id);
	}

	@Override
	public void add(Programme programme) {
		em.persist(programme);		
	}

	@Override
	public void edit(Programme programme) {
		em.merge(programme);	
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Programme.class, id));	
	}

	@Override
	public void updateValidate(Programme programme) {
		programme.setCheked(false);
		programme.setValidate(true);
		em.merge(programme);
		//Query query = em.createQuery("UPDATE Programme p SET p.validate=1 and p.cheked=0 WHERE p.id ="+id);			
		//query.executeUpdate();	
	}
	
	@Override
	public void askForRechek(int id){
		Query query = em.createQuery("UPDATE Programme p SET p.cheked=1 WHERE p.id ="+id);			
		query.executeUpdate();
	}
	
	@Override
	public void acceptReRechek(Programme programme){
		programme.setCheked(false);
		programme.setValidate(false);
		em.merge(programme);
		Query  queryCount= em.createQuery("select count (a) from ArtworkPoint a where a.programme.id="+programme.getId());
		Long count=(Long)queryCount.getSingleResult();
		if (count>0){
			System.out.println("test count >0");
			Query  queryDelete= em.createQuery("delete from ArtworkPoint a where a.programme.id="+programme.getId());
			queryDelete.executeUpdate();
		}
		
		//Query query = em.createQuery("UPDATE Programme p SET p.cheked=0 and p.validate=0 WHERE p.id ="+id);			
		//query.executeUpdate();
	}


	@Override
	public void calculatePoints(Programme programme) {
		Query  queryCount= em.createQuery("select count (a) from ArtworkPoint a where a.programme.id="+programme.getId());
		Long count=(Long)queryCount.getSingleResult();
		System.out.println("test count");
		if (count>0){
			System.out.println("test count > 0");
			Query  queryDelete= em.createQuery("delete from ArtworkPoint a where a.programme.id="+programme.getId());
			queryDelete.executeUpdate();
		}
		List<Artwork> listArtworkByProgramme=null;
		TypedQuery<Artwork> query = em.createQuery("select distinct(e.artwork) from Exploitation e "
													+ "where e.programme.id="+programme.getId()+" "
													+ "and artwork_id is not null",
													Artwork.class);	
		try {
			listArtworkByProgramme = query.getResultList();
		} catch (NoResultException e ) {
		}
		System.out.println("calculate pints");
		for (Artwork artwork : listArtworkByProgramme){
			System.out.println("caaa"+artwork.getId());
			Query  query1= em.createQuery("select sum(e.point) from Exploitation e where e.artwork.id="+artwork.getId());
			try {
				Double sumPoint= (Double) query1.getSingleResult();
				System.out.println("point :"+sumPoint);
				//ArtworkPointId artworkPointId= new ArtworkPointId(artwork.getId(), programme.getId());
				ArtworkPoint artworkPoint=new ArtworkPoint(artwork, programme, sumPoint);
				System.out.println("testting");
				em.persist(artworkPoint);
			} catch (NoResultException e ) {
			}
			
		}
		
	}
	
	@Override
	public List<ArtworkPoint> allPointsByProgramme(Programme programme) {
		System.out.println("test service");
		List<ArtworkPoint> listArtworkPoint=null;
		System.out.println("test1  :"+programme.getId());
		TypedQuery<ArtworkPoint> query = em.createQuery("Select distinct(p) from ArtworkPoint p where p.programme.id="+programme.getId(), ArtworkPoint.class);	
		try {
			listArtworkPoint = query.getResultList();
		} catch (NoResultException e ) {
		}
		System.out.println("test2List  :"+listArtworkPoint.size());
		return listArtworkPoint;
	}

}
