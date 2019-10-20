package com.zking.Service.impl;

import com.zking.Service.LoginService;
import com.zking.entity.UserEntity;
import com.zking.repository.Myrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    Myrepository loginRepository;
    @Override
    public List<UserEntity> findAll(){
        return loginRepository.findAll();
    }
    //登录
    public List<UserEntity> findByUsernameAndPassword(String username,String password){
        return loginRepository.findByUsernameAndPassword(username,password);
    }
    //注册
    @Override
    public void save(UserEntity login){
        loginRepository.save(login);
    }
    //查用户名
    @Override
        public List<UserEntity> findByUsername(String username){
        return loginRepository.findByUsername(username);
    }

}
