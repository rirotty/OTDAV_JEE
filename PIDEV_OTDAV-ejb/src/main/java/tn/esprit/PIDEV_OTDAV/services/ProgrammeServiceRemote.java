package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;
import javax.ejb.Remote;

import tn.esprit.PIDEV_OTDAV.entity.ArtworkPoint;
import tn.esprit.PIDEV_OTDAV.entity.Programme;
import tn.esprit.PIDEV_OTDAV.entity.User;

@Remote
public interface ProgrammeServiceRemote {

	public List<Programme> all();
	public Programme show(int id);
	public void add(Programme programme);
	public void edit(Programme programme);
	public void delete(int id);
	public void updateValidate(Programme programme);
	public void calculatePoints(Programme programme);
	void askForRechek(int id);
	void acceptReRechek(Programme programme);
	List<Programme> allByUser(User user);
	List<ArtworkPoint> allPointsByProgramme(Programme programme);

}
