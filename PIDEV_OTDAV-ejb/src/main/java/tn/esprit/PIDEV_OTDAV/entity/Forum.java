package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forum implements Serializable {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String commentaire;
	private Date date;
	
	@ManyToOne
	private User user;
}
