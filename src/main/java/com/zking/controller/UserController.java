package com.zking.controller;

import com.zking.Service.LoginService;
import com.zking.Service.impl.InfoServiceImpl;
import com.zking.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    public InfoServiceImpl infoServiceImpl;
    //查询信息
    @RequestMapping("/infoQuery")
    public String findAll(Model model){
        List<UserEntity> userEntities = loginService.findAll();
        model.addAttribute("emps",userEntities);
        return "infoQuery";
    }
    //修改页面
    @RequestMapping("/alter")
    public String getuid(Integer uid,Model model){
        if (uid!=null){
            UserEntity byId = infoServiceImpl.findById(uid);
            model.addAttribute("stu",byId);
        }
        return "alter";
    }

//修改用户信息
/*    @RequestMapping("/alter")
    public String alter(Integer uid,String username,String sex,String phone,String email){
        UserEntity userEntity1=infoServiceImpl.findById(uid);
        userEntity1.setUsername(username);
        userEntity1.setSex(sex);
        userEntity1.setPhone(phone);
        userEntity1.setEmail(email);
        infoServiceImpl.updateUser(userEntity1);
        return "alter";
    }*/

//保存修改
    @RequestMapping("/add")
    public String add(UserEntity userEntity){
        infoServiceImpl.saveUser(userEntity);
        return "redirect:/infoQuery";
    }

    @RequestMapping("/update")
    public String update(UserEntity userEntity){
        infoServiceImpl.updateUser(userEntity);
        return "redirect:/infoQuery";
    }

//删除用户信息
    @RequestMapping("/delete/{uid}")
    public String delete(@PathVariable Integer uid){
        infoServiceImpl.delete(uid);
        return "redirect:/infoQuery";
    }
}
