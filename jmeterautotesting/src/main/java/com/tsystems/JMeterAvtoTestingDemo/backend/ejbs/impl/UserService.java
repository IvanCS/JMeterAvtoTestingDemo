package com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.impl;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.entities.SysUserEntity;
import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IUserService;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository ("userService")
public class UserService extends GenericDAO<SysUserEntity,Integer> implements IUserService {

    public UserService() {
        setEntityClass(SysUserEntity.class);
    }

    @Override
    @Transactional
    public boolean checkCredentials(String login, String password) {
       Query query = getSession().createQuery("from SysUserEntity su where su.login = :login and su.password = :password");
       query.setString("login",login);
       query.setString("password", password);

       SysUserEntity userEntity = (SysUserEntity) query.uniqueResult();

       if(userEntity == null) {
           return false;
       }    else{
           return true;
       }

    }
}
