package tn.esprit.PIDEV_OTDAV.presentation.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import tn.esprit.PIDEV_OTDAV.entity.Category;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;
import tn.esprit.PIDEV_OTDAV.services.CategoryService;

@ManagedBean(name="categoryBean")
@SessionScoped
public class CategoryBean implements Serializable{
	private String categoryName;
	private Boolean isActif;
	private String icon;
	private List<Category> categories;
	private Integer CategoryIdToBeUpdated;
	private List<Category> searchCat;

	public Integer getCategoryIdToBeUpdated() {
		return CategoryIdToBeUpdated;
	}


	public void setCategoryIdToBeUpdated(Integer categoryIdToBeUpdated) {
		CategoryIdToBeUpdated = categoryIdToBeUpdated;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public List<Category> getCategories() {
		categories=categoryService.categories();
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public CategoryService getCategoryService() {
		return categoryService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@EJB
	CategoryService categoryService ;
	
	public String addCategory(){
		categoryService.addCategory(new Category(categoryName,isActif, icon));
	return "null";
	}
	
	public void supprimer(Integer categoryId){
		categoryService.delete(categoryId);
	}
	
	
	public String modifier(Category category) {


		this.setCategoryName(category.getCategoryName());
		this.setIcon(category.getIcon());
		this.setIsActif(category.isActif());
		this.setCategoryIdToBeUpdated(category.getId());
		return "update?faces-redirect=true";
	}
	
	public String mettreAjr(){
		categoryService.update(new Category( categoryName,  isActif, icon,CategoryIdToBeUpdated));
		return "category?faces-redirect=true";
		
	}
	
	public String bannCategory(Integer categoryId){
		categoryService.bannirCategory(categoryId);
		return "category?faces-redirect=true";
		
	}
	public List<Category> getSearchCat() {
		searchCat =categoryService.SearchCategory(categoryName);
		return searchCat;
	}


	public void setSearchCat(List<Category> searchCat) {
		this.searchCat = searchCat;
	}
	
	
	
}
