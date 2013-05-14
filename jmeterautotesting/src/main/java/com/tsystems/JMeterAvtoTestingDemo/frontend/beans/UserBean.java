package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.SysUserEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IGenegicDAO;
@ManagedBean
@RequestScoped
//@Component
public class UserBean {
	
	//@Autowired
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
