/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IUserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * @author ipetrush
 */
@ManagedBean(name = "authorisationMB")
@ViewScoped
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

    public void tryAuthorize() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            boolean isSigned = false;
            isSigned = getUserService().checkCredentials(getLogin(), getPassword());
            if (isSigned) {
                context.getExternalContext().redirect("/jmeter-autotesting-demo-1.0.0/main_page.jsf");
            } else {
                throw new Exception("Authorization is failed!");
            }


        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authorization error", "Invalid data");
            context.addMessage(null, msg);

        }

    }

    public void logout(){
        try{
            setLogin(null);
            FacesContext.getCurrentInstance().getExternalContext(). redirect("/start_page.jsf");

        }        catch (Exception e){
            e.printStackTrace();
        }

    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getLogin() {
        String user_login = null;
        try {
            user_login = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user_login").toString();

        } catch (Exception e) {
            e.getMessage();
        }
        if (user_login != null) {
            login = user_login;
        }

        return login;
    }



    public void setLogin(String login) {
        this.login = login;
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_login", login);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
