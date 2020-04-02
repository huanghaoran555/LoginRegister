package com.zking.controller;

import com.zking.Service.CommentService;
import com.zking.Service.impl.CommentServiceImpl;
import com.zking.entity.VideoComment;
import com.zking.repository.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentService commentService;
    @Autowired
    CommentServiceImpl commentServiceImpl;
    //查询所有影片评论
    @RequestMapping("/deletecomment")
    public  String findAll(Model model){
        List<VideoComment> commentEntities=commentService.findAll();
        model.addAttribute("com",commentEntities);
        return "deletecomment";
    }
    //保存评论
    @RequestMapping("/addComment")
    public String addComment(VideoComment videoComment){
        commentServiceImpl.saveComment(videoComment);
        return "redirect:/single";
    }
    //删除评论
    @RequestMapping("/deletecomment2/{comment_id}")
    public String deleteComment(@PathVariable int comment_id){
        commentServiceImpl.deletecomment(comment_id);
        return "redirect:/deletecomment";
    }
}
