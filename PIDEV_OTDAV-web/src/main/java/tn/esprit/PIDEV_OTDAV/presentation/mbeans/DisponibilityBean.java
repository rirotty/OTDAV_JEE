package tn.esprit.PIDEV_OTDAV.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.PIDEV_OTDAV.entity.Disponibility;
import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.services.MeetingService;

@ManagedBean
@ViewScoped
public class DisponibilityBean {
	
	private int id;
	
	private Date date;
	
	private int heure;
	
	private String etat ;
	
	private User user;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private List<Disponibility> disponibilites;
	
	@EJB
	MeetingService dispoService;
	
	@PostConstruct
	public void init(){
		
		date = new Date();
						
	}
	
	public String addDisponibility(){
		dispoService.addDispo(new Disponibility(date, heure,"non reserve","attribuer","non", email));
		return "/pages/admin/manageDispo?faces-redirect=true";
	}
	
	public void Confirmate(int id){
		dispoService.ConfirmationMeeting(id);
		
	}
	
	public void Cancel(int id){
		dispoService.cancelDesponibility(id);
	}
	
	public void Delete (int id){
		dispoService.deleteDesponibility(id);
	}
	


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

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MeetingService getDispoService() {
		return dispoService;
	}

	public void setDispoService(MeetingService dispoService) {
		this.dispoService = dispoService;
	}

	public List<Disponibility> getDisponibilites() {
		disponibilites = dispoService.getAllDispo();
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibility> disponibilites) {
		this.disponibilites = disponibilites;
	}


	
	

}
