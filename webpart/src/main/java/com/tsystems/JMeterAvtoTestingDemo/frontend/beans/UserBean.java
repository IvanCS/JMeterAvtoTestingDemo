package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tsystems.jmeteravtotestingdemo.ejbs.interfaces.IUserService;
import com.tsystems.jmeteravtotestingdemo.entityes.User;

@ManagedBean
@RequestScoped
public class UserBean {
	
	@EJB
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private List<User> users;

	public List<User> getUsers() {
		if (users==null)
		{
			users = userService.getUsers();
		}
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
