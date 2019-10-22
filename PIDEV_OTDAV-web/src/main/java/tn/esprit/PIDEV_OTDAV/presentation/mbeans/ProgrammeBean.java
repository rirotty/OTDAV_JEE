package tn.esprit.PIDEV_OTDAV.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import tn.esprit.PIDEV_OTDAV.entity.Artwork;
import tn.esprit.PIDEV_OTDAV.entity.ArtworkPoint;
import tn.esprit.PIDEV_OTDAV.entity.Exploitation;
import tn.esprit.PIDEV_OTDAV.entity.Programme;
import tn.esprit.PIDEV_OTDAV.entity.Role;
import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.entity.subCategory;
import tn.esprit.PIDEV_OTDAV.services.ArtworkService;
import tn.esprit.PIDEV_OTDAV.services.CategoryService;
import tn.esprit.PIDEV_OTDAV.services.ExploitationService;
import tn.esprit.PIDEV_OTDAV.services.ProgrammeService;
import java.util.Date;
import java.util.List;

@ManagedBean(name="programmeBean")
@RequestScoped
public class ProgrammeBean {

	private int id;
	private Date date;
	private float montant;
	private List<Programme> listProgrammes;
	private List<Programme> listProgrammesByUser;
	private int idExploitation;
	private int durre;
	private String oeuvreNom;
	private Artwork artwork;
	private int selectedArtworkId;
	private List<Artwork> listArtwork;
	private int selectedCategoryId;
	private List<subCategory> listCategory;
	private List<Exploitation> listExploitation;
	private static Programme selectedProgramme;
	private List<ArtworkPoint> listArtworkPoint;
	private static User connectedUser= new User(2, Role.Neighbor,"test");
	
	@Named
	@EJB
	ProgrammeService programmeService;
	
	@EJB
	private CategoryService categoryService;
	
	@EJB
	private ExploitationService exploitationService;
	
	@EJB
	private ArtworkService artworkService;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public List<Programme> getListProgrammes() {
		return programmeService.all();
	}
	public void setListProgrammes(List<Programme> listProgrammes) {
		this.listProgrammes = listProgrammes;
	}
	
	public List<Programme> getListProgrammesByUser() {
		listProgrammesByUser=programmeService.allByUser(connectedUser);
		return listProgrammesByUser;
	}
	public void setListProgrammesByUser(List<Programme> listProgrammesByUser) {
		this.listProgrammesByUser = listProgrammesByUser;
	}
	public int getIdExploitation() {
		return idExploitation;
	}
	public void setIdExploitation(int idExploitation) {
		this.idExploitation = idExploitation;
	}
	public int getDurre() {
		return durre;
	}
	public void setDurre(int durre) {
		this.durre = durre;
	}
	public String getOeuvreNom() {
		return oeuvreNom;
	}
	public void setOeuvreNom(String oeuvreNom) {
		this.oeuvreNom = oeuvreNom;
	}
	public Artwork getArtwork() {
		return artwork;
	}
	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}
	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
	public List<subCategory> getListCategory() {
		listCategory=categoryService.subCategories();
		return listCategory;
	}
	public void setListCategory(List<subCategory> listCategory) {
		this.listCategory = listCategory;
	}
	public List<Exploitation> getListExploitation() {
		return exploitationService.all(selectedProgramme);
	}
	public void setListExploitation(List<Exploitation> listExploitation) {
		this.listExploitation = listExploitation;
	}
	
	public Programme getSelectedProgramme() {
		return selectedProgramme;
	}
	public void setSelectedProgramme(Programme selectedProgramme) {
		this.selectedProgramme = selectedProgramme;
	}
	
	public List<Artwork> getListArtwork() {
		listArtwork=artworkService.all();
		return listArtwork;
	}
	
	public void setListArtwork(List<Artwork> listArtwork) {
		this.listArtwork = listArtwork;
	}
	
	
	public int getSelectedArtworkId() {
		return selectedArtworkId;
	}
	public void setSelectedArtworkId(int selectedArtworkId) {
		this.selectedArtworkId = selectedArtworkId;
	}
	
	
	public static User getConnectedUser() {
		return connectedUser;
	}
	public static void setConnectedUser(User connectedUser) {
		ProgrammeBean.connectedUser = connectedUser;
	}
	
	
	public List<ArtworkPoint> getListArtworkPoint() {
		listArtworkPoint=programmeService.allPointsByProgramme(selectedProgramme);
		return listArtworkPoint;
	}
	public void setListArtworkPoint(List<ArtworkPoint> listArtworkPoint) {
		this.listArtworkPoint = listArtworkPoint;
	}
	public String ajouter(){
		programmeService.add(new Programme(date, montant, connectedUser));
		return "listProgramme?faces-redirect=true";
	}
	
	public String modifierForm(Programme programme){
		this.id=programme.getId();
		this.montant=programme.getMontant();
		this.date=programme.getDate();
		this.selectedProgramme=programme;
		return "modifProgramme?faces-redirect=true";
	}
	
	public String modifierCommit(){
		//programmeService.edit(new Programme(id, date, montant));
		programmeService.edit(selectedProgramme);
		exploitationService.updatePoints(selectedProgramme);
		return "listProgramme?faces-redirect=true";
	}
	
	public void supprimer(int id){
		programmeService.delete(id);
	}
	
	public String validate(Programme programme){
		programmeService.updateValidate(programme);
		return "listProgramme?faces-redirect=true";
	}
	
	public String listExploitation(Programme programme){
		selectedProgramme=programme;
		if (selectedProgramme.isValidate()==true)
			 return "StaticListExploitation?faces-redirect=true";
		return "mainExploitation?faces-redirect=true&includeViewParams=true";
	}
	
	public String ajouterExploitation(){	
		if (oeuvreNom.length()>0){
			subCategory subCategory1=categoryService.getsubCategoryById(selectedCategoryId);
			System.out.println("infooo  :"+subCategory1.getSubcategoryName()+"aaaaa :"+oeuvreNom);
			exploitationService.add(new Exploitation(durre, selectedProgramme, 0, oeuvreNom, null, subCategory1, connectedUser));
		}else{
			Artwork artwork= artworkService.find(selectedArtworkId);
			exploitationService.add(new Exploitation(durre, selectedProgramme,0, null, artwork, artwork.getSubCategory(), connectedUser));
		}
		System.out.println("selected prog id :"+selectedProgramme.getId());
		exploitationService.updatePoints(selectedProgramme);
		return "mainExploitation?faces-redirect=true&includeViewParams=true";
	}
	
	public void supprimerExploitation(int id){
		exploitationService.delete(id);
	}
	
	public void askForRechek(Programme programme){
		programmeService.askForRechek(programme.getId());	
	}
	
	public void acceptReRechek(Programme programme){
		programmeService.acceptReRechek(programme);
	}
	
	public String listExploitationAdmin(Programme programme){
		selectedProgramme=programme;
		return "/pages/admin/repartitionPagesAdmin/StaticListExploitation?faces-redirect=true";
	}
	
	public void calculerPoint(Programme programme){
		programmeService.calculatePoints(programme);
	}
	
	public String viewPoints(Programme programme){
		selectedProgramme=programme;
		return "artworkProgramePoints?faces-redirect=true";
	}
}
