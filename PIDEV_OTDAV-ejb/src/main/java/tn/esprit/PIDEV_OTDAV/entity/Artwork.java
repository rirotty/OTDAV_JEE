package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artwork implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String author;

	private boolean isActive;

	@ManyToOne
	private User user;

	@ManyToOne
private subCategory subCategory;

	@ManyToOne//(optional = true , fetch = FetchType.LAZY )
	private Declaration declaration;



	//@OneToMany( mappedBy = "programme",cascade = CascadeType.ALL,orphanRemoval = true )
	//private List<ArtworkPoint> programmes = new ArrayList<>();

//	@OneToMany( mappedBy = "programme",cascade = CascadeType.MERGE,orphanRemoval = true )
//	private List<ArtworkPoint> programmes = new ArrayList<>();

	
	public Artwork(int id, String name, subCategory subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.subCategory = subCategory;
	}

	public Artwork() {
		super();

	}

	public Artwork(tn.esprit.PIDEV_OTDAV.entity.subCategory selectedSubCategory, User selectedUser, String name2,
			String description2, String author2, boolean isActive2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	//public List<ArtworkPoint> getProgrammes() {
		//return programmes;
	//}

	//public void setProgrammes(List<ArtworkPoint> programmes) {
		//this.programmes = programmes;
	//}

	public subCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(subCategory subCategory) {
		this.subCategory = subCategory;
	}



	public Artwork(subCategory subCategory, User user, String name,
			String description, String author, boolean isActive, Declaration declaration) {
		
		super();
		this.name = name;
		this.description = description;
		this.author = author;
		this.isActive = isActive;
		this.user = user;
		this.subCategory = subCategory;
		this.declaration = declaration;

	}
	
	
	

}
