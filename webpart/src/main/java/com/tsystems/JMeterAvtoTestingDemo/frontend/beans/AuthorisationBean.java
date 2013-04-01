/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author ipetrush
 */
@ManagedBean
@ViewScoped
@Component
public class AuthorisationBean {

    public final String RELATIVE_VIEW_NAME = "authorisationForm";
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
            //context.getExternalContext().redirect("startPagase.xhtml");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authorization error", "Invalid data");
            context.addMessage(null, msg);
        }
    }
    
    
    
}
