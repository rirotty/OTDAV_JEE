package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.PIDEV_OTDAV.entity.File;
import tn.esprit.PIDEV_OTDAV.entity.Membership;

@Local
public interface MembershipServiceRemote {

	// public int addMembership(Membership membership,File file);

	public List<Membership> memberships();

	public void update(Membership membership);

	public void delete(int membershipId);

	int addMembership(Membership membership);

	public Membership getMembershipById(int membershipId);

	public Integer mRejected();
	public Integer mNotRejected();

	public Integer mEnabled();

}
