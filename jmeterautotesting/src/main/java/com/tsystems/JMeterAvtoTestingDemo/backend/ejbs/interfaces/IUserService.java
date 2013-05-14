package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces;

public interface IUserService{

	boolean checkCredentials(String login,String password);

}
