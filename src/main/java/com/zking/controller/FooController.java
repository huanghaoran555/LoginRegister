package com.zking.controller;

import com.zking.Service.LoginService;
import com.zking.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/5/12.
 */

@RestController
public class FooController {

    @Autowired
    private LoginService loginService;

    //登录页面
    @RequestMapping("/auth")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("auth");
        return mv;
    }

    //注册页面
    @RequestMapping("/reg")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("reg");
        return mv;
    }

    //登陆功能
    @PostMapping("/auth")
    public ModelAndView Login(@RequestParam("username") String username, @RequestParam("password") String password,
                              Map<String, Object> map,
                              HttpSession session) {
        List<UserEntity> login = loginService.findByUsernameAndPassword(username, password);
        System.out.println(username + ":" + password);
        ModelAndView success = new ModelAndView();
        //登录判断
        if (username.isEmpty() || password.isEmpty()) {
            success.setViewName("auth");
            //success.addObject("tip2","用户名或密码不能为空");
            map.put("tip2", "用户名或密码不能为空");
            return success;
        }
        if (login.size() > 0) {
            //session中保存用户信息
            session.setAttribute("loginUser", username);
            //登录成功并跳转
            success.setViewName("UHome");
        } else {
            //success.setViewName("404");
            success.setViewName("auth");
            map.put("tip2", "用户名或密码错误");
            return success;
        }
        return success;
    }

    //注册功能
    @PostMapping("/reg")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password")
            String password, @RequestParam("email") String email, @RequestParam("phone") String phone
            ,@RequestParam("sex") String sex, Map<String, Object> map) {
        ModelAndView success = new ModelAndView();
        //注册信息为空的条件判断
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()||sex.isEmpty()) {
            success.setViewName("reg");
            // success.addObject("tip1","信息不能为空");
            map.put("tip1", "信息不能为空");
            return success;
        }
        //两次密码不一样的判断条件
/*        if(!password.equals(password2)){
            success.setViewName("reg");
            success.addObject("tip2","两次密码不一样");
            return success;
        }*/
        //判断是否取到用户，如果没有就保存在数据库中
        List<UserEntity> us = loginService.findByUsername(username);
        if (us.size() == 0) {
            UserEntity registers = new UserEntity();
            registers.setPassword(password);
            registers.setUsername(username);
            registers.setEmail(email);
            registers.setPhone(phone);
            registers.setSex(sex);
            loginService.save(registers);
            success.setViewName("auth");
        } else {
            success.setViewName("404");
        }
        return success;
    }

    //游客首页
    @RequestMapping("/Home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("Home");
        return mv;
    }

    //用户首页
    @RequestMapping("/UHome")
    public ModelAndView UHome() {
        ModelAndView mv = new ModelAndView("UHome");
        return mv;
    }

    //上传
    @GetMapping("/upload")
    public ModelAndView upload() {
        ModelAndView mv = new ModelAndView("upload");
        return mv;
    }

    private static String UPLOAD_FOLDER = "G://MyUpload//";

    //上传处理
    @PostMapping("/upload")
    public  String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request, HttpServletResponse response) {
        String code=request.getParameter("code");
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择视频上传");
            //return "redirect:/upload";
            try {
                    request.getRequestDispatcher("upload.html").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //拿到视频并保存
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_FOLDER + filename);
            Files.write(path, bytes);
            //将文件保存在static文件夹
            file.transferTo(new File(UPLOAD_FOLDER + filename));
            redirectAttributes.addFlashAttribute("message", "上传成功" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "redirect:/upload";
        try {
            if (code!=null&&code.equals("uploadvideo")) {
                request.getRequestDispatcher("upload.html").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //个人中心
    @RequestMapping("/admin")
    public ModelAndView admin(HttpSession session){
        ModelAndView mv = new ModelAndView("admin");
       session.getAttribute("loginUser");
        return mv;
    }
    //历史
    @RequestMapping("/history")
    public ModelAndView history(){
        ModelAndView mv = new ModelAndView("history");
        return mv;
    }
    //动作
    @RequestMapping("/movies")
    public ModelAndView action(){
        ModelAndView mv = new ModelAndView("movies");
        return mv;
    }
    //喜剧
    //好莱坞
    //篮球
    @RequestMapping("/sports")
    public ModelAndView basket(){
        ModelAndView mv = new ModelAndView("sports");
        return mv;
    }
    //足球
    //游泳
    //赛车
    //音乐
    //新闻
    @RequestMapping("/news")
    public ModelAndView news(){
        ModelAndView mv = new ModelAndView("news");
        return mv;
    }
    //播放页面
   /* @RequestMapping("/single")
    public ModelAndView single(){
        ModelAndView mv = new ModelAndView("single");
        return mv;
    }*/
    @RequestMapping("/videosAdd")
    public ModelAndView videosAdd(){
        ModelAndView mv = new ModelAndView("videosAdd");
        return mv;
    }
/*    @RequestMapping("/infoQuery")
    public ModelAndView infoQuery(){
        ModelAndView mv = new ModelAndView("infoQuery");
        return mv;
    }*/
    @RequestMapping("/studentdetail")
    public ModelAndView studentdetail(){
        ModelAndView mv = new ModelAndView("studentdetail");
        return mv;
    }
    @RequestMapping("/deletecomment")
    public ModelAndView deletecomment(){
        ModelAndView mv = new ModelAndView("deletecomment");
        return mv;
    }
    @RequestMapping("/documentAdd")
    public ModelAndView documentAdd(){
        ModelAndView mv = new ModelAndView("documentAdd");
        return mv;
    }
    @RequestMapping("/usercommentlist")
    public ModelAndView usercommentlist(){
        ModelAndView mv = new ModelAndView("usercommentlist");
        return mv;
    }
   /* @RequestMapping("/uservideoQuery")
    public ModelAndView uservideoQuery(){
        ModelAndView mv = new ModelAndView("uservideoQuery");
        return mv;
    }*/
}
