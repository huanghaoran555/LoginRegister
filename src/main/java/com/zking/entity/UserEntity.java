package com.zking.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/12.
 */
//声明bean类为Entity
@Entity
public class UserEntity {
    //声明id
    @Id
    //声明id自增长
    @GeneratedValue
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String sex;

    public UserEntity(Integer uid, String username, String password, String phone, String email,String sex) {
        this.uid=uid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.sex=sex;
    }

    public UserEntity() {
    }
@Basic
    public Integer getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
@Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
@Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
@Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Basic
    public String getSex(){return sex;}

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity login = (UserEntity) o;
        return Objects.equals(username, login.username) &&
                Objects.equals(password, login.password);
    }
@Override
public int hashCode() {
    return Objects.hash(username, password);
}
}
