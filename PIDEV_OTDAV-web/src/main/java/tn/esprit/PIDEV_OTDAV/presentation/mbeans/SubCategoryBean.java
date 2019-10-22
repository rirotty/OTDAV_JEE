package tn.esprit.PIDEV_OTDAV.presentation.mbeans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import tn.esprit.PIDEV_OTDAV.entity.Category;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;
import tn.esprit.PIDEV_OTDAV.services.CategoryService;


@ManagedBean(name="subcategoryBean")
@SessionScoped
public class SubCategoryBean {

	private String subcategoryName;
	private Boolean isActif;
	private int point;
	private List<Category> categories  ;
	private Integer SelectedCategoryId;
	private List<subCategory> subcategories  ;
	private HorizontalBarChartModel horizontalBarModel;
	private Integer subCategoryIdToBeUpdated;

	public Integer getSubCategoryIdToBeUpdated() {
		return subCategoryIdToBeUpdated;
	}

	public void setSubCategoryIdToBeUpdated(Integer subCategoryIdToBeUpdated) {
		this.subCategoryIdToBeUpdated = subCategoryIdToBeUpdated;
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	public void supprimer(Integer subcategoryId){
		System.out.println("hy"+subcategoryId);
		categoryService.deleteSub(subcategoryId);;
	}
	
	public List<subCategory> getSubcategories() {

		subcategories= categoryService.subCategories();
		return subcategories;
	}
	public void setSubcategories(List<subCategory> subcategories) {
		this.subcategories = subcategories;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public List<Category> getCategories() {
		categories=categoryService.categories();
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@EJB
	 CategoryService categoryService;

	
	public Integer getSelectedCategoryId() {
		return SelectedCategoryId;
	}
	public void setSelectedCategoryId(Integer selectedCategoryId) {
		SelectedCategoryId = selectedCategoryId;
	}
	@PostConstruct
	public void init(){
	categories=categoryService.categories();
	
	}
	
		
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void addsubcategory(){
		System.out.println("hello");
		subCategory subcategory=new subCategory(subcategoryName,point,isActif);
		Category SelectedCategory=new Category();
		SelectedCategory.setId(SelectedCategoryId);
		subcategory.setCategory(SelectedCategory);
		System.out.println("hel"+subcategory);
		categoryService.addSubCategory(subcategory);
	}
	
	public void modifiersub(subCategory sub) {
		
		this.setSubcategoryName(sub.getSubcategoryName());
		this.setPoint(sub.getPoint());
		this.setIsActif(sub.isActif());
		this.setSubCategoryIdToBeUpdated(sub.getId());
	}
	
	public void mettreAjr(){
		categoryService.updateSub(new subCategory(subcategoryName,point,isActif,subCategoryIdToBeUpdated));
		
	}
	private void createHorizentalBarModel(){
		horizontalBarModel =new HorizontalBarChartModel();
		ChartSeries boys = new ChartSeries();
		/*for (int i = 0; i < subcategories.size(); i++) {
			boys.set(subcategories.get(i).getSubcategoryName(), subcategories.get(i).getPoint());

		}*/
		boys.set("ines", 55);
		boys.setLabel("Salary");

		horizontalBarModel.addSeries(boys);

		horizontalBarModel.setTitle("Salary");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Salary");
		xAxis.setMin(0);
		xAxis.setMax(3000);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("FirstName");
	}

	
	}
	
	
	

