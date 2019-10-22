package tn.esprit.PIDEV_OTDAV.presentation.mbeans;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.PIDEV_OTDAV.entity.Disponibility;
import tn.esprit.PIDEV_OTDAV.entity.Meeting;
import tn.esprit.PIDEV_OTDAV.services.MeetingService;

@ManagedBean
@ViewScoped
public class FrontBean {
	
	private Disponibility dispo;
	
	private Meeting meeting;
	
	private String QRCore = "1";
	
	
	
	@EJB
	MeetingService Service;
	
	@PostConstruct
	public void init(){
		
		LoginTestBean ll = new LoginTestBean();
		
		if(Service.verifExistUser(ll.id_user) == 1){
			this.meeting = Service.findMeetingByUserId(ll.id_user);
			this.dispo = Service.findDispoByUserId(ll.id_user);			
			this.QRCore= Service.prepareQRCodeCore(dispo.getId());
		}
				
	}
	
	public String redirect(){
		
		LoginTestBean l = new LoginTestBean();
		int val = Service.verifExistUser(l.id_user);
		
		if(val ==1){
			return "/PIDEV_OTDAV-web/template/suivie.jsf";
		}
		else{
			return "/PIDEV_OTDAV-web/template/addMeeting.jsf";
		}
			
	}

	public Disponibility getDispo() {
		return dispo;
	}

	public void setDispo(Disponibility dispo) {
		this.dispo = dispo;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public MeetingService getService() {
		return Service;
	}

	public void setService(MeetingService service) {
		Service = service;
	}

	public String getQRCore() {
		return QRCore;
	}

	public void setQRCore(String qRCore) {
		QRCore = qRCore;
	}
	
	


	
	

}
