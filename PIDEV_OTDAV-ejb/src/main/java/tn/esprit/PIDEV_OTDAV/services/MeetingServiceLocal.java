package tn.esprit.PIDEV_OTDAV.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.PIDEV_OTDAV.entity.Disponibility;
import tn.esprit.PIDEV_OTDAV.entity.Meeting;

@Local
public interface MeetingServiceLocal {
	
	public int addMeeting(Meeting m);
	public void modifyMeeting(Meeting m ,int id);
	public void CancelMeeting(int id);
	public Meeting findByUserId(int id);
	public List<Meeting> findByDate(Date date);
	public void confirmMeeting(int id);
	public String prepareQRCodeCore(int id);
	
	public void addDispo(Disponibility d);
	public List<Disponibility> getAllDispo();
	public void ConfirmationMeeting(int id);
	public List<Disponibility> getFreeDispo();
	public Disponibility updateDispo(int id,String prenom,String nom,String email,int id_user);
	public void cancelDesponibility(int id);
	public void deleteDesponibility(int id);
	
	public int verifExistUser(int id);
	public Disponibility findDispoByUserId(int id);
	public Meeting findMeetingByUserId(int id);

}
