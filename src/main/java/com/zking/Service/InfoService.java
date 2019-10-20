package com.zking.Service;

import com.zking.entity.UserEntity;

public interface InfoService {
    //保存
    UserEntity saveUser(UserEntity userEntity);
    //修改
    UserEntity updateUser(UserEntity userEntity);
    //删除
    void delete(Integer uid);
    //根据id查询
    UserEntity findById(Integer uid);
}
