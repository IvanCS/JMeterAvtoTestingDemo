package com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces;

import com.tsystems.jmeteravtotestingdemo.backend.ejbs.entities.SysUserEntity;

public interface IUserService{

	boolean checkCredentials(String login,String password);

}
