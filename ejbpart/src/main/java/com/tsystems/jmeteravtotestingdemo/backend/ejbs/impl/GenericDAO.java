package com.tsystems.jmeteravtotestingdemo.backend.ejbs.impl;

import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IGenegicDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ipetrush
 * Date: 13.05.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class GenericDAO<T, ID extends Serializable> implements IGenegicDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    @Override
    public boolean save(Object o) {
        boolean isSaved = true;
        try{

            getSession().save(o);
        }  catch (Exception e){
            isSaved = false;
        }
        return isSaved;

    }

    @Override
    public boolean delete(Object o) {
        boolean isDeleted = true;
        try{

            getSession().delete(o);
        }  catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public Object find(Serializable serializable) {
       return getSession().get(getEntityClass(),serializable);
    }

    @Override
    public List<T> getAll() {

        return getSession().createCriteria(getEntityClass()).list();
    }
}
