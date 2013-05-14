package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ipetrush
 * Date: 13.05.13
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "DEPARTMENT", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class DepartmentEntity {
    private int id;
    private String name;

    @Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
