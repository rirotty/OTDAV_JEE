package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class File implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Membership membership;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Declaration declaration;



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

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public File(String name) {
		super();
		this.name = name;
	}

	public File(int id, String name, Membership membership, Declaration declaration) {
		super();
		this.id = id;
		this.name = name;
		this.membership = membership;
		this.declaration = declaration;
	}

	public File() {
		super();
	}
	
	

}
