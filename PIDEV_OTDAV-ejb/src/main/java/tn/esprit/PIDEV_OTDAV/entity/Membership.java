package tn.esprit.PIDEV_OTDAV.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;

@Entity
public class Membership implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private subCategory subCategory;

	@ManyToOne
	private User user;

	@OneToMany(fetch=FetchType.EAGER)
	private List<File> files;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	private String status;
	private String rejectedFor;

	public Membership(tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory, Date startDate, Date expirationDate) {
		super();
		this.subCategory = subCategory;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Membership(int id, tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory, User user, List<File> files,
			Date startDate, Date expirationDate, String status, String rejectedFor) {
		super();
		this.id = id;
		this.subCategory = subCategory;
		this.user = user;
		this.files = files;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.rejectedFor = rejectedFor;
	}

	public Membership() {
		super();
	}

	public Membership(Date startDate, Date expirationDate, tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory) {
		super();
		this.subCategory = subCategory;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
	}

	public Membership(tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory) {
		super();
		this.subCategory = subCategory;
	}

	public Membership(tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory, User user, List<File> files, Date startDate,
			Date expirationDate, String status, String rejectedFor) {
		super();
		this.subCategory = subCategory;
		this.user = user;
		this.files = files;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.rejectedFor = rejectedFor;
	}

	public Membership(int id, tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory, User user, Date startDate,
			Date expirationDate, String status, String rejectedFor) {
		super();
		this.id = id;
		this.subCategory = subCategory;
		this.user = user;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.rejectedFor = rejectedFor;
	}

	public Membership(tn.esprit.PIDEV_OTDAV.entity.subCategory subCategory, Date startDate, Date expirationDate,
			User user, String rejectedFor, String status, Integer id) {
		super();
		this.id = id;
		this.subCategory = subCategory;
		this.user = user;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.rejectedFor = rejectedFor;
	}

	public Membership(subCategory subCategory, User user) {
		super();

		this.subCategory = subCategory;
		this.user = user;
	}

	public Membership(User user) {
		super();
		this.user = user;
	}
	
	

}
