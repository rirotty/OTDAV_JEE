package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Declaration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	Date declarationDate;


	@ManyToOne
	private User user;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Artwork> artworks;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}
	
	public Declaration(User user) {
		super();
		this.user = user;
	}

	public Declaration(int id, Date declarationDate, User user, List<Artwork> artworks) {
		super();
		this.id = id;
		this.declarationDate = declarationDate;
		this.user = user;
		this.artworks = artworks;
	}

	public Declaration(Date declarationDate, User user) {
		super();
		this.declarationDate = declarationDate;
		this.user = user;
	}

	public Declaration() {
		super();
	}
	
	
	
	
	

}
