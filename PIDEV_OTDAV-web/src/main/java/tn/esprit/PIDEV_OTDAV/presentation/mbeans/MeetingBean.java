package tn.esprit.PIDEV_OTDAV.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIDEV_OTDAV.entity.Disponibility;
import tn.esprit.PIDEV_OTDAV.entity.Meeting;
import tn.esprit.PIDEV_OTDAV.entity.User;
import tn.esprit.PIDEV_OTDAV.services.MeetingService;

@ManagedBean
@SessionScoped
public class MeetingBean {
	
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String type;
	
	private Date date;
	
	private int heure;
	
	private int scanned ;
	
	private int confirmed ;
	
	private int enabled ; 
	
	private int isNotCanceled ;
	
	private User user;
	
	private int SelectedDispo;
	
	private Disponibility d;
	
	private List<Disponibility> disponibilites;
	
	private int id_user ;
	
	@EJB
	MeetingService meetingService;
	
	@PostConstruct
	public void init(){
		
		date = new Date();
		LoginTestBean l = new LoginTestBean();
		this.id_user = l.id_user;
		
	}	
	
	public String addMeeting(){
		
		updateDispoStatus();
		Meeting m = new Meeting(nom, prenom, email, date, heure,SelectedDispo, id_user);
		meetingService.addMeeting(m);
		
		return "/PIDEV_OTDAV-web/template/suivie.jsf";

		
	}
	
	public void updateDispoStatus(){
		
		d = meetingService.updateDispo(SelectedDispo, prenom, nom, email,id_user);
		this.date = d.getDate();
		this.heure = d.getHeure();
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScanned() {
		return scanned;
	}

	public void setScanned(int scanned) {
		this.scanned = scanned;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getIsNotCanceled() {
		return isNotCanceled;
	}

	public void setIsNotCanceled(int isNotCanceled) {
		this.isNotCanceled = isNotCanceled;
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

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public List<Disponibility> getDisponibilites() {
		disponibilites = meetingService.getFreeDispo();
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibility> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public int getSelectedDispo() {
		return SelectedDispo;
	}

	public void setSelectedDispo(int selectedDispo) {
		SelectedDispo = selectedDispo;
	}

	public Disponibility getD() {
		return d;
	}

	public void setD(Disponibility d) {
		this.d = d;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}
	
	


	
	
	
	

}
