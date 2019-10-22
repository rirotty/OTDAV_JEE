package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.Category;

@Stateless
@LocalBean
public class ArtworkService implements ArtworkServiceRemote {

	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	EntityManager em;

	@Override
	public Artwork find(int id) {
		return em.find(Artwork.class, id);
	}

	@Override
	public List<Artwork> all() {
		List<Artwork> listArtwork = null;
		TypedQuery<Artwork> query = em.createQuery("Select a from Artwork a", Artwork.class);
		try {
			listArtwork = query.getResultList();
		} catch (NoResultException e) {
		}
		return listArtwork;
	}

	@Override
	public int addArtwork(Artwork artwork) {

		em.persist(artwork);

		return artwork.getId();
	}

	@Override
	public void update(Artwork artwork) {
		em.merge(artwork);
	}

	@Override
	public void delete(int artworkId) {
		em.remove(em.find(Artwork.class, artworkId));
	}
	
	@Override
	public List<Artwork> myArtworks(Integer myId) {
		Query query = em.createQuery("SELECT a FROM Artwork a  WHERE a.user.id=:myId");
		query.setParameter("myId", myId);
                return  query.getResultList();
	}

}
