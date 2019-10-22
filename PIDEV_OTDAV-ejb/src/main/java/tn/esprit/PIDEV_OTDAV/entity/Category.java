package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String CategoryName;
	private boolean isActif;
	private String icon;
	private int point;
	
	



	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


	

	public Category(String categoryName, boolean isActif, String icon) {
		super();
		CategoryName = categoryName;
		this.isActif = isActif;
		this.icon = icon;
	}
	public Category() {
		super();
	}
	public Category(String categoryName, boolean isActif, String icon,int id) {
		super();
		this.id = id;
		CategoryName = categoryName;
		this.isActif = isActif;
		this.icon = icon;
	}

	public Category(boolean isActif) {
		super();
		this.isActif = isActif;
	}

	
}
