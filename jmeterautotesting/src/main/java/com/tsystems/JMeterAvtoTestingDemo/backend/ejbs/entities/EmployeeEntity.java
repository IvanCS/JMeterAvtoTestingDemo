package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 5/19/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "EMPLOYEE", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class EmployeeEntity {
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    private DepartmentEntity departmentByDepartment;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "FIRSTNAME")
    @Basic
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @javax.persistence.Column(name = "LASTNAME")
    @Basic
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @javax.persistence.Column(name = "POSITION")
    @Basic
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "DEPARTMENT", referencedColumnName = "ID")
    public DepartmentEntity getDepartmentByDepartment() {
        return departmentByDepartment;
    }

    public void setDepartmentByDepartment(DepartmentEntity departmentByDepartment) {
        this.departmentByDepartment = departmentByDepartment;
    }
}
