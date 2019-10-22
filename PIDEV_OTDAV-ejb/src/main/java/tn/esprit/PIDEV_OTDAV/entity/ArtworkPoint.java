package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class ArtworkPoint implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    private Artwork artwork;
 
    @ManyToOne
    private Programme programme;
    
    private Double points;

	public ArtworkPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ArtworkPoint( Artwork artwork, Programme programme, Double points) {
		super();
		this.artwork = artwork;
		this.programme = programme;
		this.points = points;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
    
    
    
    
	
}
