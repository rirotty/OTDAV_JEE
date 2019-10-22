package tn.esprit.PIDEV_OTDAV.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.PIDEV_OTDAV.entity.Declaration;

@Stateless
@LocalBean
public class DeclarationService implements DeclarationServiceRemote {
	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	EntityManager em;
	
	UserService us;
	
	
	
	
	@Override
	public Declaration find(int id) {
		return em.find(Declaration.class, id);
	}

	@Override
	public List<Declaration> all() {
		List<Declaration> listDeclaration = null;
		TypedQuery<Declaration> query = em.createQuery("Select d from Declaration d", Declaration.class);
		try {
			listDeclaration = query.getResultList();
		} catch (NoResultException e) {
		}
		return listDeclaration;
	}

	@Override
	public Declaration addDeclaration(Declaration declaration) {

		declaration.setDeclarationDate(new Date());

		em.persist(declaration);

		return declaration;
	}

	@Override
	public void update(Declaration declaration) {
		em.merge(declaration);
	}

	@Override
	public void delete(int declarationId) {
		em.remove(em.find(Declaration.class, declarationId));
	}
	
	

}
