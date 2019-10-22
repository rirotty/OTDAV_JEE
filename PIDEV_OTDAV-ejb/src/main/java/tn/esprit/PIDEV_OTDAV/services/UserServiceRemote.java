package tn.esprit.PIDEV_OTDAV.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIDEV_OTDAV.entity.User;

@Remote
public interface UserServiceRemote {
	public int addUser(User user);
	void updateUserPassword(String newPass, int id);
	void deleteUser(int id);
	User doLogin(String username,String password);
	List<User> findAll();
	User findOnById(int id);
	public void updateUser(User user);
}
