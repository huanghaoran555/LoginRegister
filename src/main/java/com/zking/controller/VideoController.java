package com.zking.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.zking.Service.VideoService;
import com.zking.Service.impl.VideoServiceImpl;
import com.zking.entity.VideoEntity;
import com.zking.repository.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoServiceImpl videoServiceImpl;
    @Autowired
    private VideoDao videoDao;
    //视频管理查询所有影片信息
    @RequestMapping("/uservideoQuery")
    public String findAll(Model model){
        List<VideoEntity> videoEntities=videoService.findAll();
        model.addAttribute("vi",videoEntities);
        return "uservideoQuery";
    }
    //首页影片查询
    @RequestMapping("/UHome")
    public String findAll2(Model model){
        List<VideoEntity> videoEntities=videoService.findAll();
        model.addAttribute("vi",videoEntities);
        return "UHome";
    }
    //查询影片播放地址
    @RequestMapping("/single")
    public String findByPath(String Path,Model model){
        VideoEntity ve =videoServiceImpl.findByPath(Path);
        model.addAttribute("vd",ve);
        return "single";
    }
    //修改影片页面
    @RequestMapping("/alterVideo")
    public String getVideoId(Integer video_id,Model model){
        if (video_id!=null){
            VideoEntity vi = videoServiceImpl.findById(video_id);
            model.addAttribute("v",vi);
        }
        return "alterVideo";
    }
    //保存修改
    @RequestMapping("/addVideo")
    public String addVideo(VideoEntity videoEntity){
        videoServiceImpl.saveVideo(videoEntity);
        return "redirect:/uservideoQuery";
    }
    @RequestMapping("/updateVideo")
    public String updateVideo(VideoEntity videoEntity){
        videoServiceImpl.updateVideo(videoEntity);
        return "redirect:/uservideoQuery";
    }
    @RequestMapping("/deleteVideo/{video_id}")
    public String deleteVideo(@PathVariable Integer video_id){
        videoServiceImpl.deleteVideo(video_id);
        return "redirect:/uservideoQuery";
    }
}
