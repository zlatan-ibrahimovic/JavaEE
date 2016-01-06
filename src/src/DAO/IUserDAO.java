package DAO;

import java.util.List;

import javax.ejb.Local;

import Entities.User;

@Local
public interface IUserDAO {
	
	void create(User user);
	void printNameAllUser();
	User find(String email, String password);
	User find(String email);
	List<User> findAllUser();
	void detach(User user);
}
