package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PIDEV_OTDAV.entity.Category;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;

@Stateless
@LocalBean
public class CategoryService implements CategoryServiceRemote {
	@PersistenceContext(unitName = "PIDEV_OTDAV-ejb")
	EntityManager em ;

	@Override
	public int addCategory(Category category) {
		em.persist(category);
		return category.getId();
	}

	@Override
	public void delete(int categoryId) {
		em.remove(em.find(Category.class, categoryId));		
	}

	@Override
	public void update(Category category) {
			em.merge(category);		
	}

	@Override
	public List<Category> categories() {
		List<Category> categories=null;
		TypedQuery<Category> query = em.createQuery("Select e from Category e "
				, Category.class);	
		try {
			categories = query.getResultList();

		} catch (NoResultException e ) {
			
		}
		return categories;
	

	}
	@Override
	public List<subCategory> subCategories() {
		List<subCategory> subCategories=null;
		TypedQuery<subCategory> query1 = em.createQuery("Select e from subCategory e "
				, subCategory.class);	
		try {
			subCategories = query1.getResultList();
			System.out.println("hello"+subCategories);
		} catch (NoResultException e ) {
			
		}
		return subCategories;
		}

	@Override
	public subCategory getsubCategoryById(int subcategoryId) {
		return em.find(subCategory.class, subcategoryId);
	}
	
	public List<Category> SearchCategory(String categoryName) {
		Query query = em.createQuery("SELECT a FROM Category a  WHERE a.CategoryName Like '"+categoryName+"'");
		//query.setParameter("categoryName", categoryName);
                return  query.getResultList();
	}



	@Override
	public int addSubCategory(subCategory subcategory) {
		System.out.println(subcategory);
		em.persist(subcategory);
		return subcategory.getId();	
	}





	@Override
	public void deleteSub(int subcategoryId) {
		em.remove(em.find(subCategory.class, subcategoryId));				
	}


	public void updateSub(subCategory subcategory) {
		em.merge(subcategory);		
		
	}

	@Override
	public Category getCategoryById(int categoryId) {
				return em.find(Category.class, categoryId);
			}





	public void bannirCategory(Integer categoryId) {
		Query query = em.createQuery("UPDATE Category e SET e.isActif=0 WHERE e.id ="+categoryId);			
		 query.executeUpdate();
	}



	//@Override
/*	public void bannirSubCatgeory(subCategory subcategory) {
		// TODO Auto-generated method stub
		
	}*/



	@Override
	public void updateSub(Category subcategory) {
		// TODO Auto-generated method stub
		
	}






	//@Override
/*	public void bannirSubCatgeory(subCategory subcategory) {
		// TODO Auto-generated method stub
		
	}*/





	
	
	
}
	



