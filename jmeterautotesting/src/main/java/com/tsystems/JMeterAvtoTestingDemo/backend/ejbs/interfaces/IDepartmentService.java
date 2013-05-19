package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.DepartmentEntity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ipetrush
 * Date: 13.05.13
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public interface IDepartmentService extends IGenegicDAO,Serializable {
    DepartmentEntity getByName(String name);
}
