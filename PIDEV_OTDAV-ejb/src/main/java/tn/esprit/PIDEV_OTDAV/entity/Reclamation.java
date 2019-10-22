package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Reclamation implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private Type type;
	private String description;
	

}
