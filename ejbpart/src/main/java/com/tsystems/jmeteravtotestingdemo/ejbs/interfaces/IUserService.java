package com.tsystems.jmeteravtotestingdemo.ejbs.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.tsystems.jmeteravtotestingdemo.entityes.User;

@Remote
public interface IUserService {
	List<User> getUsers();
	boolean checkCredentials(String user,String password);
	void addUser(User user);
	void removeUser(User user);
}
