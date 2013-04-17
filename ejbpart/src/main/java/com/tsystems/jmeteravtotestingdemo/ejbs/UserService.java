package com.tsystems.jmeteravtotestingdemo.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tsystems.jmeteravtotestingdemo.ejbs.interfaces.IUserService;
import com.tsystems.jmeteravtotestingdemo.entityes.User;

@Stateless
public class UserService implements IUserService {
	
	@PersistenceContext(unitName="filedb")
	EntityManager entityManager;

	public List<User> getUsers()   {
		TypedQuery<User> query =  entityManager.createQuery("from User",User.class);
		return query.getResultList();
	}
	
	public void addUser(User user)   {
		entityManager.persist(user);
	}
	
	public void removeUser(User user)   {
		User us = entityManager.getReference(User.class, user.getId());
		entityManager.remove(us);
	}
	
	public boolean checkCredentials(String user,String password)
	{
		TypedQuery<User> query = entityManager.createQuery("from User where login = :login and password = :pass", User.class);
		query.setParameter("login", user);
		query.setParameter("pass", password);
		return query.getSingleResult() != null;
	}

}
