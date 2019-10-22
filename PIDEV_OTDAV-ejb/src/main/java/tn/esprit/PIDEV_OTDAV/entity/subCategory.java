package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;


@Entity
public class subCategory  implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String subcategoryName;
	private int point;
	private boolean isActif;
	
	@ManyToOne
	private Category category;
	

	@OneToMany (mappedBy = "subCategory") //sorry xD Hhhhhhh no prob at least We solved sthg *u did xD <3 apparemment ya3mél fi infinte loop idk where tho hummm okay I'll 
    private List<Artwork> artworks;
	
	@OneToMany(mappedBy = "subCategory")
	private List<Membership> memberships;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}
	public subCategory() {
		super();
	}
	public subCategory(String subcategoryName, int point, boolean isActif) {
		super();
		this.subcategoryName = subcategoryName;
		this.point = point;
		this.isActif = isActif;
	}
	public subCategory(String subcategoryName, int point, boolean isActif,int id) {
		super();
		this.id = id;
		this.subcategoryName = subcategoryName;
		this.point = point;
		this.isActif = isActif;
	}
	public subCategory(int id) {
		super();
		this.id = id;
	}
	
	


}
