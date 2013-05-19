package com.tsystems.JMeterAvtoTestingDemo.frontend.beans;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.DepartmentEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.EmployeeEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IDepartmentService;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IGenegicDAO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 5/19/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "employeeMB")
@RequestScoped
public class EmployeeManagedBean implements Serializable {

    @ManagedProperty(value = "#{employeeService}")
    private IGenegicDAO employeeService;
    @ManagedProperty(value = "#{departmentService}")
    private IDepartmentService departmentService;
    private EmployeeEntity employeeEntity;

    private List<EmployeeEntity> employees;
    private List<DepartmentEntity> departments;

    public EmployeeManagedBean() {

    }

    @PostConstruct
    private void init() {
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        employeeEntity = new EmployeeEntity();
        employeeEntity.setDepartmentByDepartment(new DepartmentEntity());
    }

    public IGenegicDAO getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(IGenegicDAO employeeService) {
        this.employeeService = employeeService;
    }

    public IDepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }


    public List<EmployeeEntity> getEmployees() {
        return getEmployeeService().getAll();
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public List<DepartmentEntity> getDepartments() {
        return getDepartmentService().getAll();
    }

    public void setDepartments(List<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public void createEmployee() {
        boolean isCreated = false;
        FacesMessage msg;
        DepartmentEntity department = getDepartmentService().getByName(getEmployeeEntity().getDepartmentByDepartment().getName());

        getEmployeeEntity().setDepartmentByDepartment(department);

        isCreated = getEmployeeService().persist(getEmployeeEntity());

        if (isCreated) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Instance is added", "New employee :" + getEmployeeEntity().getFirstname() + " " + getEmployeeEntity().getLastname());

        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Invalid data");

        }
        FacesContext.getCurrentInstance().addMessage(null, msg);

        clear();
    }

    private void clear() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setDepartmentByDepartment(new DepartmentEntity());
        setEmployeeEntity(entity);
    }
}