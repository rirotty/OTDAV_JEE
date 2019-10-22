package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Question implements Serializable {
		@Id
		@GeneratedValue (strategy=GenerationType.IDENTITY)
		private int id;
		private Theme theme;
		private String description;
		private String reponse;
}
