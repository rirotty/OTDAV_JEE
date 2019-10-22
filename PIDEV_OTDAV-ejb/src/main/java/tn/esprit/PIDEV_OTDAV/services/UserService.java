package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.services.MembershipService;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName="PIDEV_OTDAV-ejb")
	private EntityManager em;
	
	


	@Override
	public int addUser(User user) {
		em.persist(user);
		return user.getId();
	}

	@Override
	public void updateUserPassword(String newPass,int id) {
	User user=em.find(User.class,id);
	user.setPassword(newPass);
		
	}

	@Override
	public void deleteUser(int id) {
		User user=em.find(User.class,id);
		em.remove(user);
		
	}

	@Override
	public User doLogin(String username, String password) {

		TypedQuery<User> query=em.createQuery("Select e from User e where (e.username=:username and e.password=:password) or(e.mail=:username and e.password=:password)",User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user=null;
		try {
			user=query.getSingleResult();

		} catch (NoResultException e) {
		
		}
		if (user != null)
		{
			User.UserConnected=user;
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List l;

		
		Query query=em.createQuery("select e from User e");
		l=query.getResultList();
		
		return l;
	}

	@Override
	public User findOnById(int id) {
		User user=em.find(User.class,id);
				return user;
	}
	
@Override
	public void updateUser(User user) {

	em.merge(user);
		
	}
}
