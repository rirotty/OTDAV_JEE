package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ArtworkPointId implements Serializable{

	@Column(name = "artwork_id")
	private int artworkId;
	
	@Column(name = "programme_id")
	private int  programmeId;

	public ArtworkPointId(int artworkId, int programmeId) {
		super();
		this.artworkId = artworkId;
		this.programmeId = programmeId;
	}

	public ArtworkPointId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getArtworkId() {
		return artworkId;
	}

	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public int getProgrammeId() {
		return programmeId;
	}

	public void setProgrammeId(int programmeId) {
		this.programmeId = programmeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artworkId;
		result = prime * result + programmeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtworkPointId other = (ArtworkPointId) obj;
		if (artworkId != other.artworkId)
			return false;
		if (programmeId != other.programmeId)
			return false;
		return true;
	}

	
	
	
}
