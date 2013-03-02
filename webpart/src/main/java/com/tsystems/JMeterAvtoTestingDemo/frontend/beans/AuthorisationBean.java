/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ipetrush
 */
@Component
@ManagedBean
@SessionScoped
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

    
    
    
    
}
