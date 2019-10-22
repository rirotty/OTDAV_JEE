package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.PIDEV_OTDAV.entity.Artwork;

@Remote
public interface ArtworkServiceRemote {

	public Artwork find(int id);
	public List<Artwork> all();
	public int addArtwork (Artwork artwork);
	public void update(Artwork artwork);
	public void delete(int artworkId);
	public List<Artwork> myArtworks(Integer myId);
}
