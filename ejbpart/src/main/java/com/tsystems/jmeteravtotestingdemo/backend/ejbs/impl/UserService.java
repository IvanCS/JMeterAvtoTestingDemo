package com.tsystems.jmeteravtotestingdemo.backend.ejbs.impl;

import com.tsystems.jmeteravtotestingdemo.backend.ejbs.entities.SysUserEntity;
import com.tsystems.jmeteravtotestingdemo.backend.ejbs.interfaces.IUserService;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;



@Repository
public class UserService extends GenericDAO<SysUserEntity,Integer> implements IUserService {

    @Override
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
