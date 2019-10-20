package com.zking.Service.impl;

import com.zking.Service.InfoService;
import com.zking.entity.UserEntity;
import com.zking.repository.Myrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
   private Myrepository myrepository;
    @Override
    public UserEntity saveUser(UserEntity userEntity){
        UserEntity user1 =myrepository.save(userEntity);
        return user1;
    }
    @Override
    public UserEntity updateUser(UserEntity userEntity){
        return myrepository.save(userEntity);
    }
    @Override
    public void delete(Integer uid){
        myrepository.delete(uid);
    }
   @Override
    public UserEntity findById(Integer uid){
        return myrepository.findById(uid).get(0);
    }
}
