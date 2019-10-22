package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Programme implements Serializable{
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	private float montant;
	
	private boolean validate;
	
	private boolean cheked;
	@ManyToOne
	private User user;
	
//	@OneToMany( mappedBy = "artwork",fetch = FetchType.EAGER, cascade = CascadeType.MERGE,orphanRemoval = true )
//	private List<ArtworkPoint> artworks = new ArrayList<>();
	
	@OneToMany(mappedBy="programme", cascade=CascadeType.MERGE,orphanRemoval = true)
	private List<Exploitation> listExpolitation;
	

	public Programme() {
		super();
	}

	public Programme(int id, Date date, float montant) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
	}


	public Programme(Date date, float montant,User user) {
		super();
		this.date = date;
		this.montant = montant;
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public boolean isCheked() {
		return cheked;
	}

	public void setCheked(boolean cheked) {
		this.cheked = cheked;
	}

	public List<Exploitation> getListExpolitation() {
		return listExpolitation;
	}

	public void setListExpolitation(List<Exploitation> listExpolitation) {
		this.listExpolitation = listExpolitation;
	}

//	public List<ArtworkPoint> getArtworks() {
//		return artworks;
//	}
//
//	public void setArtworks(List<ArtworkPoint> artworks) {
//		this.artworks = artworks;
//	}
	
	
}
