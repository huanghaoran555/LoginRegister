package com.zking.repository;

import com.zking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface Myrepository extends JpaRepository<UserEntity,Integer>, JpaSpecificationExecutor<UserEntity> {
    //登录
    @Query(value ="select * from  user_entity where username=?and password=?",nativeQuery = true)
    List<UserEntity> findByUsernameAndPassword(String username, String password);
    //注册
    @Query(value = "select * from  user_entity  where username=?", nativeQuery = true)
    List<UserEntity> findByUsername(String username);
   @Query(value = "select * from user_entity where uid=? order by uid",nativeQuery = true)
    List<UserEntity> findById(Integer uid);
   /* @Query(value = "select * from user_entity where uid=?",nativeQuery = true)
    List<UserEntity> deleteByUid(Integer uid);*/
}
