package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Meeting implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String type;
	
	private Date date;
	
	private int heure;
	
	private int scanned = 0;
	
	private int confirmed = 0;
	
	private int enabled = 1; 
	
	private int isNotCanceled = 1;
	
	private int idDispo;
	
	private int id_user =1;
	
	@ManyToOne
	private User user;
	
	public Meeting() {

	}
	
	// soo?? n5amem  rit mamstou? le -_-
	
	public Meeting(String nom, String prenom, String email, String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.type = type;
	}
	
	

	public Meeting(String nom, String prenom, String email, String type, Date date) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.type = type;
		this.date = date;
	}
	
	

	public Meeting(String nom, String prenom, String email, Date date, int heure, User user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date = date;
		this.heure = heure;
		this.user = user;
	}
	

	public Meeting(String nom, String prenom, String email, Date date, int heure, int idDispo, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date = date;
		this.heure = heure;
		this.idDispo = idDispo;
		this.id_user = id_user;
	}
	
	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScanned() {
		return scanned;
	}

	public void setScanned(int scanned) {
		this.scanned = scanned;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIsNotCanceled() {
		return isNotCanceled;
	}

	public void setIsNotCanceled(int isNotCanceled) {
		this.isNotCanceled = isNotCanceled;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getHeure() {
		return heure;
	}



	public void setHeure(int heure) {
		this.heure = heure;
	}



	public int getIdDispo() {
		return idDispo;
	}



	public void setIdDispo(int idDispo) {
		this.idDispo = idDispo;
	}



	public int getId_user() {
		return id_user;
	}



	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	
	
	

}
