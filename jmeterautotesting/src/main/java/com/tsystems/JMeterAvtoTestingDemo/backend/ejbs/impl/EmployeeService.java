package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.impl;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.EmployeeEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IEmployeeService;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 5/19/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("employeeService")
public class EmployeeService extends GenericDAO<EmployeeEntity,Integer>  implements IEmployeeService{
    public EmployeeService() {
        setEntityClass(EmployeeEntity.class);
    }
}
