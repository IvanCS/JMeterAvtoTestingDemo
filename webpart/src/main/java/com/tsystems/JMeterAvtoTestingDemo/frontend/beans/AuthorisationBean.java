/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IGenegicDAO;
import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestScope;

/**
 *
 * @author ipetrush
 */
@ManagedBean
@RequestScoped
@Component
public class AuthorisationBean {

    public final String RELATIVE_VIEW_NAME = "authorisationForm";

    @Autowired
    private IUserService userService;

    private String login;
    private  String password;

    /**
     * Creates a new instance of AuthorisationBean
     */
    public AuthorisationBean() {
    }

    public String getRELATIVE_VIEW_NAME() {
        return RELATIVE_VIEW_NAME;
    }

    public void tryAuthorize(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            getUserService().checkCredentials(getLogin(),getPassword());
            //context.getExternalContext().redirect("startPagase.xhtml");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authorization error", "Invalid data");
            context.addMessage(null, msg);
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
