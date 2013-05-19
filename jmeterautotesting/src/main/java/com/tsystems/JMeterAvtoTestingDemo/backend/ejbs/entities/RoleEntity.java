package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 5/19/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "role", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class RoleEntity {
    private int id;
    private String name;
    private Collection<SysUserEntity> sysUsersById;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "NAME")
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

        RoleEntity that = (RoleEntity) o;

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

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<SysUserEntity> getSysUsersById() {
        return sysUsersById;
    }

    public void setSysUsersById(Collection<SysUserEntity> sysUsersById) {
        this.sysUsersById = sysUsersById;
    }
}
