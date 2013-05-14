/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IUserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * @author ipetrush
 */
@ManagedBean(name = "authorisationMB")
@RequestScoped
public class AuthorisationManagedBean implements Serializable {

    public final String RELATIVE_VIEW_NAME = "authorisationForm";

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;
    private String login;
    private String password;

    /**
     * Creates a new instance of AuthorisationBean
     */
    public AuthorisationManagedBean() {
        //WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        // userService = ctx.getBean(UserService.class);
    }

    public String getRELATIVE_VIEW_NAME() {
        return RELATIVE_VIEW_NAME;
    }

    public String tryAuthorize() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            getUserService().checkCredentials(getLogin(), getPassword());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authorization error", "Invalid data");
            context.addMessage(null, msg);
            return "failed";
        }
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
