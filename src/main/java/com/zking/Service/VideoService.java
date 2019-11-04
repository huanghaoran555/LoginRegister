package com.zking.Service;

import com.zking.entity.VideoEntity;
import java.util.List;

public interface VideoService {
    //查询所有
    List<VideoEntity> findAll();
    //保存
    VideoEntity saveVideo(VideoEntity videoEntity);
    //修改
    VideoEntity updateVideo(VideoEntity videoEntity);
    //删除
    void deleteVideo(Integer video_id);
    //根据id查询
    VideoEntity findById(Integer video_id);
    //查询路径
    VideoEntity findByPath(String Path);
}
