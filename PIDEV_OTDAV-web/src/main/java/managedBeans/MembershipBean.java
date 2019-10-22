package managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.Category;
import tn.esprit.PIDEV_OTDAV.entity.CivilSituation;
import tn.esprit.PIDEV_OTDAV.entity.Declaration;
import tn.esprit.PIDEV_OTDAV.entity.EmailClient;
import tn.esprit.PIDEV_OTDAV.entity.File;
import tn.esprit.PIDEV_OTDAV.entity.Membership;
import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;
import tn.esprit.PIDEV_OTDAV.services.ArtworkService;
import tn.esprit.PIDEV_OTDAV.services.CategoryService;
import tn.esprit.PIDEV_OTDAV.services.DeclarationService;
import tn.esprit.PIDEV_OTDAV.services.MembershipService;
import tn.esprit.PIDEV_OTDAV.services.UserService;

@ManagedBean(name = "membershipBean")
@SessionScoped

public class MembershipBean {

	// membership stuff

	private subCategory subCategory;

	private List<File> files;
	private Date startDate;
	private Date expirationDate;
	private String status;
	private String rejectedFor;
	private List<Membership> memberships;


	private List<subCategory> subCategories;
	private Integer SelectedSubCategoryId;
	private Integer MembershipIdToBeUpdated;
	private String category;
	private List<subCategory> categories = new ArrayList<>();
	private Membership membership;

	@EJB
	CategoryService categoryService;
	@EJB
	MembershipService membershipService;

	// user stuff

	private int cin;
	@Temporal(TemporalType.DATE)
	private Date cinDate;
	private String adress;
	private int postCode;
	private int phone;
	private int fax;
	private CivilSituation civilSituation;
	private int nbrChildren;
	private int rib;
	private String stageName;
	private String[] statuses = { "Accepted by the committee (Please send missing files and make payment)",
			"Pending for contract signing", "Enabled", "Disabled", "Rejected" };

	private User user;

	private Integer UserIdToBeUpdated;

	@EJB
	UserService userService;

	// declaration stuff
	Date declarationDate;
	private Declaration declaration;
	
	private Integer declarationId;
	
	EmailClient ec;

	@EJB
	DeclarationService declarationService;

	// artwork stuff

	private String name;
	private String description;
	private String author;
	private boolean isActive;

	private Artwork artwork;
	private List<Artwork>artworks;
	
	
	public List<Artwork> getArtworks() {
		artworks = artworkService.myArtworks(1);
		return artworks;
	}

	
	

	@EJB
	ArtworkService artworkService;
	
	

	@PostConstruct
	public void init() {
		category = "test";
		categories = categoryService.subCategories();


		this.membership = new Membership();

	}
	
	


	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}




	public List<subCategory> getCategories() {
		categories = categoryService.subCategories();
		return categories;
	}

	public Integer getSelectedSubCategoryId() {
		return SelectedSubCategoryId;
	}

	public void setSelectedSubCategoryId(Integer selectedSubCategoryId) {
		SelectedSubCategoryId = selectedSubCategoryId;
	}

	public subCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(subCategory subCategory) {
		this.subCategory = subCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectedFor() {
		return rejectedFor;
	}

	public void setRejectedFor(String rejectedFor) {
		this.rejectedFor = rejectedFor;
	}

	public Integer getMembershipIdToBeUpdated() {
		return MembershipIdToBeUpdated;
	}

	public MembershipService getMembershipService() {
		return membershipService;
	}

	public void setMembershipService(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	public List<subCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<subCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public Membership getMembership() {
		return membership;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	public void setMembershipIdToBeUpdated(Integer membershipIdToBeUpdated) {
		MembershipIdToBeUpdated = membershipIdToBeUpdated;
	}

	public void setCategories(List<subCategory> categories) {
		this.categories = categories;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public List<Membership> getMemberships() {
		memberships = membershipService.memberships();
		return memberships;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Date getCinDate() {
		return cinDate;
	}

	public void setCinDate(Date cinDate) {
		this.cinDate = cinDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public CivilSituation getCivilSituation() {
		return civilSituation;
	}

	public void setCivilSituation(CivilSituation civilSituation) {
		this.civilSituation = civilSituation;
	}

	public int getNbrChildren() {
		return nbrChildren;
	}

	public void setNbrChildren(int nbrChildren) {
		this.nbrChildren = nbrChildren;
	}

	public int getRib() {
		return rib;
	}

	public void setRib(int rib) {
		this.rib = rib;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Integer getUserIdToBeUpdated() {
		return UserIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
		UserIdToBeUpdated = userIdToBeUpdated;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String[] getStatuses() {
		return statuses;
	}

	public void setStatuses(String[] statuses) {
		this.statuses = statuses;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public DeclarationService getDeclarationService() {
		return declarationService;
	}

	public void setDeclarationService(DeclarationService declarationService) {
		this.declarationService = declarationService;
	}

	public ArtworkService getArtworkService() {
		return artworkService;
	}

	public void setArtworkService(ArtworkService artworkService) {
		this.artworkService = artworkService;
	}
	
	public Integer getDeclarationId() {
		return declarationId;
	}

	public void setDeclarationId(Integer declarationId) {
		this.declarationId = declarationId;
	}
	
	




	
	

	public String addMembership() throws MessagingException {
		subCategory selectedCategory = new subCategory();
		System.out.println("hello" + selectedCategory.getSubcategoryName());
		// membership.setUser(userService.findOnById(1));
		User selectedUser = userService.findOnById(1);

		subCategory SelectedSubCategory = new subCategory();
		SelectedSubCategory.setId(SelectedSubCategoryId);

		membershipService.addMembership(new Membership(SelectedSubCategory, selectedUser));
		// UserIdToBeUpdated = (membership.getUser().getId());
		EmailClient.sendAsHtml("rahmabenromdhane15@gmail.com", "OTDAV ADMIN", "<h2>Dear user,</h2><p>Your membership request has been sent to our comittee. You can follor the status of your request on our website. </p>");

		return "/pages/memberInfoForm?faces-redirect=true";
	}

	public void update(Membership membership) {
		this.setSubCategory(membership.getSubCategory());
		this.setStartDate(membership.getStartDate());
		this.setExpirationDate(membership.getExpirationDate());
		this.setUser(membership.getUser());
		this.setRejectedFor(membership.getRejectedFor());
		this.setStatus(membership.getStatus());
		this.setMembershipIdToBeUpdated(membership.getId());

	}

	public void up() {
		Membership membership = membershipService.getMembershipById(MembershipIdToBeUpdated);
		membership.setExpirationDate(expirationDate);
		membership.setId(MembershipIdToBeUpdated);
		membership.setRejectedFor(rejectedFor);
		membership.setStatus(status);
		membership.setUser(user);
		membership.setStartDate(startDate);
		membership.setSubCategory(subCategory);
		membershipService.update(membership);
	}

	public void delete(Integer membershipId) {
		membershipService.delete(membershipId);
	}

	public String AdduserInfo() {
		User selectedUser = userService.findOnById(1);
   Declaration declaration=declarationService.addDeclaration(new Declaration(selectedUser));
   this.setDeclarationId(declaration.getId());
		User user = userService.findOnById(1);
		user.setCin(cin);
		user.setCinDate(cinDate);
		user.setAdress(adress);
		user.setPostCode(postCode);
		user.setPhone(phone);
		user.setFax(fax);
		user.setCivilSituation(civilSituation);
		user.setNbrChildren(nbrChildren);
		user.setRib(rib);
		user.setStageName(stageName);

		userService.updateUser(user);
		System.out.println((declarationId));
		
		return"/pages/addArtwork?faces-redirect=true";
	}
	
	public String addArtwork() {
		
		subCategory selectedCategory = new subCategory();
		System.out.println("hello" + selectedCategory.getSubcategoryName());
		// membership.setUser(userService.findOnById(1));
		User selectedUser = userService.findOnById(1);

		subCategory SelectedSubCategory = new subCategory();
		SelectedSubCategory.setId(SelectedSubCategoryId);
		

		artworkService.addArtwork(new Artwork(SelectedSubCategory, selectedUser,name,description,author,isActive,declarationService.find(declarationId)));
		
		
		
		
		return "/pages/myArtworks?faces-redirect=true";
		
		
		
	}

}
