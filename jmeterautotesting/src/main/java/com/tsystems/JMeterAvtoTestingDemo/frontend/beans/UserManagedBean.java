package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.SysUserEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IGenegicDAO;

@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable{

    @ManagedProperty(value = "#{userService}")
	private IGenegicDAO userService;

    private SysUserEntity user;

    private List<SysUserEntity> entities;


    public UserManagedBean() {
    }
    @PostConstruct
    private void init(){
        entities = new ArrayList<>();
        user = new SysUserEntity();

    }
    public IGenegicDAO getUserService() {
        return userService;
    }

    public void setUserService(IGenegicDAO userService) {
        this.userService = userService;
    }



    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }

    public List<SysUserEntity> getEntities() {

        return getUserService().getAll();
    }

    public void setEntities(List<SysUserEntity> entities) {
        this.entities = entities;
    }

    public void createNewUser(){
        boolean isCreated = false;
        FacesMessage msg;
        isCreated = getUserService().persist(getUser());
        if(isCreated){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Success", "Nre user :" + user.getLogin());

        } else{
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authorization error", "Invalid data");

        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        entities = null;
    }

}
