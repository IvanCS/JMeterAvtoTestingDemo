package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ipetrush
 * Date: 13.05.13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public interface IGenegicDAO<T,ID extends Serializable> {

    Session getSession();

    boolean save(T t);
    boolean persist(T o);
    boolean delete(T t);
    List<T> getAll();
    T find(ID id);
}
