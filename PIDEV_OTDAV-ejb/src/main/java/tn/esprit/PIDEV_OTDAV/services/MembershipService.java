package tn.esprit.PIDEV_OTDAV.services;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.File;
import tn.esprit.PIDEV_OTDAV.entity.Membership;
import tn.esprit.PIDEV_OTDAV.entity.User;

@Stateless
@LocalBean
public class MembershipService implements MembershipServiceRemote {

	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	EntityManager em;
	LocalDate today = LocalDate.now();
	LocalDate nextYear = LocalDate.now().plusYears(1);
	Date dToday = java.sql.Date.valueOf(today);
	Date dNextYear = java.sql.Date.valueOf(nextYear);
	UserService us;

	// connected=User.UserConnected;

	@Override
	public int addMembership(Membership membership) {
		membership.setStatus("To be processed");
		membership.setStartDate(dToday);
		membership.setExpirationDate(dNextYear);
		membership.setRejectedFor(null);
		//membership.setUser(us.findOnById(1));

		em.persist(membership);
		// file.setMembership(membership);
		// em.persist(file);

		return membership.getId();
	}

	@Override
	public List<Membership> memberships() {
		List<Membership> memberships = null;
		TypedQuery<Membership> query = em.createQuery("Select m from Membership m ", Membership.class);
		
		try {
			memberships = query.getResultList();
		} catch (NoResultException e) {

		}
		
		return memberships;

	}

	@Override
	public void update(Membership membership) {
		em.merge(membership);
	}

	@Override
	public void delete(int membershipId) {
		em.remove(em.find(Membership.class, membershipId));
	}

	@Override
	public Membership getMembershipById(int membershipId) {

		Membership membership = em.find(Membership.class, membershipId);
		return membership;
	}
	
	@Override
	public Integer mRejected() {
		
		
		TypedQuery<Long>query= em.createQuery("SELECT COUNT (a)  FROM Artwork a WHERE a.status=rejected",Long.class);
		query.setParameter("rejected","Rejected");
		Long count=query.getSingleResult();
		
                return Math.toIntExact(count) ;
	}

	@Override
	public Integer mNotRejected() {
		
		TypedQuery<Long>query= em.createQuery("SELECT COUNT (a) FROM Artwork a WHERE  a.status=processed",Long.class);
		
		query.setParameter("processed","To be processed");

		Long count=query.getSingleResult();
		
                return Math.toIntExact(count) ;
	}
	
	@Override
	public Integer mEnabled() {
		
		
		TypedQuery<Long>query= em.createQuery("SELECT COUNT (a) FROM Artwork a WHERE a.status=enabled",Long.class);
		query.setParameter("enabled","Enabled");
		
		Long count=query.getSingleResult();
		
                return Math.toIntExact(count) ;
	}

}
