package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIDEV_OTDAV.entity.Category;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;


@Remote
public interface CategoryServiceRemote {
	public int addCategory(Category category);
	public Category getCategoryById(int categoryId);
	public subCategory getsubCategoryById(int subcategoryId);
	public List<Category> categories();
	public void delete(int categoryId);
	public void update(Category category);
	public List<subCategory> subCategories();
	public int addSubCategory(subCategory subcategory);
	public void deleteSub(int subcategoryId);

	public void updateSub(Category subcategory);
	void updateSub(subCategory subcategory);
	void bannirCategory(Integer categoryId);


	public List<Category> SearchCategory(String categoryName);

	//public void bannirSubCatgeory(subCategory subcategory);
	
}
