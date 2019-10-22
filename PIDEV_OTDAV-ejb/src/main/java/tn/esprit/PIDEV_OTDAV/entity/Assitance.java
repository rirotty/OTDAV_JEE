package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Assitance implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
}
