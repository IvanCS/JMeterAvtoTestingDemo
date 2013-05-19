package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces;

import java.io.Serializable;

public interface IUserService extends IGenegicDAO, Serializable{

	boolean checkCredentials(String login,String password);

}
