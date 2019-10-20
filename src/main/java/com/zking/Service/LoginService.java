package com.zking.Service;

import com.zking.entity.UserEntity;
import java.util.List;

public interface LoginService {
    //查询所有
    List<UserEntity> findAll();
    //登录
    List<UserEntity> findByUsernameAndPassword(String username,String password);
    //注册
    void save(UserEntity login);
    List<UserEntity> findByUsername(String username);
}
