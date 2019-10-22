package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;


@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static User UserConnected ;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = true)
	private Integer cin;
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date cinDate;
	


	private String lastName;
	private String username;
	private String mail;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private boolean isEnabled;
	@Column(nullable = true)
	private String adress;
	@Column(nullable = true)
	private Integer postCode;
	@Column(nullable = true)
	private Integer phone;
	@Column(nullable = true)
	private Integer fax;
	@Column(nullable = true)
	private Date inscriptionDate;
	@Column(nullable = true)
	private CivilSituation civilSituation;
	@Column(nullable = true)
	private Integer nbrChildren;
	@Column(nullable = true)
	private Integer rib;

	private String stageName;
// tmrw és2él lprof kén jé chaamelt enti apart hetha? 
	//4 methode webservice 


	private Role role;
	
	private String name;
	
	@OneToMany (fetch=FetchType.EAGER) //chbih maykamalch
	private List<Meeting> meeting;

	@OneToMany(fetch=FetchType.EAGER)//y5aréj féhom fér8in 3la 5ater mouch ya9ra fel les tables d'association w ki ta3mél asociation yod5él fi infnte loop :( mouch nharha fama wehed fel classe sartlou el faza w warah el prof ? ines and 3malt nafs éli 3amlétou, éna bidi apparemment 3andi nafs lmochkla chkoun ines ines lmézyéna xD na3refhech woh w manhabech naarafha woh woh  ya ya sé3a nés mlé7 enti nes mle7 hhhhhhh 3aychk
	private List<Artwork> artworks;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Membership> memberships;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Declaration> declarations;




	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public List<Meeting> getMeeting() {
		return meeting;
	}

	public void setMeeting(List<Meeting> meeting) {
		this.meeting = meeting;
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}



	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
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

	public List<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	public List<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	@OneToMany (mappedBy = "user")
	private List<Disponibility> disponibilytes;

	public User(){
	}
	
	
	
	public User(int id, Role role, String name) {
		super();
		this.id = id;
		this.role = role;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int id) {
		super();
		this.id = id;
	}
	
	
	

}
