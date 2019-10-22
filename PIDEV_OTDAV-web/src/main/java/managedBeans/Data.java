package managedBeans;



	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;

import tn.esprit.PIDEV_OTDAV.entity.CivilSituation;




	@ManagedBean
	@SessionScoped
	public class Data {
	public CivilSituation[] getCivilSituations(){
	return CivilSituation.values();
	}
	}


