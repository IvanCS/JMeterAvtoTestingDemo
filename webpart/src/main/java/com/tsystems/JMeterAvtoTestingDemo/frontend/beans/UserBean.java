package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tsystems.jmeteravtotestingdemo.backend.ejbs.entities.SysUserEntity;
import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IGenegicDAO;
import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@ManagedBean
@RequestScoped
@Component
public class UserBean {
	
	@Autowired
	private IGenegicDAO userService;

    List<SysUserEntity> entities;

    public IGenegicDAO getUserService() {
        return userService;
    }

    public void setUserService(IGenegicDAO userService) {
        this.userService = userService;
    }

    List<SysUserEntity>getAllSysUsers(){
         return getUserService().getAll();
     }


}
