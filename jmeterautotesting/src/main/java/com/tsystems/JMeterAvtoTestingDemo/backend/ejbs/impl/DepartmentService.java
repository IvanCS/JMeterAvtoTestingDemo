package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.impl;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.DepartmentEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IDepartmentService;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: ipetrush
 * Date: 13.05.13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */

@Repository("departmentService")
public class DepartmentService extends GenericDAO<DepartmentEntity,Integer> implements IDepartmentService {

    public DepartmentService() {
        setEntityClass(DepartmentEntity.class);
    }

    @Override
    @Transactional
    public DepartmentEntity getByName(String name) {
        Query query = getSession().createQuery("from DepartmentEntity de where de.name = :name");
        query.setString("name",name);


        DepartmentEntity departmentEntity = (DepartmentEntity) query.uniqueResult();

        if(departmentEntity == null) {
            return null;
        }    else{
            return departmentEntity;

        }
    }
}
