package com.zking.Service.impl;

import com.zking.Service.VideoService;
import com.zking.entity.VideoEntity;
import com.zking.repository.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
@Autowired
    VideoDao videoDao;
@Override
    public List<VideoEntity> findAll(){
    return videoDao.findAll();
}
@Override
public  VideoEntity saveVideo(VideoEntity videoEntity){
    VideoEntity v1=videoDao.save(videoEntity);
    return v1;
}
@Override
    public VideoEntity findById(Integer video_id){
    return videoDao.findById(video_id).get(0);
}
@Override
public List<VideoEntity> findByMovie_name(String movie_name){
    return videoDao.findByMovie_name(movie_name);
}
@Override
    public VideoEntity updateVideo(VideoEntity videoEntity){
    return videoDao.save(videoEntity);
}
@Override
    public void delete(Integer video_id){
    videoDao.delete(video_id);
  }
}
