package com.zking.Service.impl;

import com.zking.Service.CommentService;
import com.zking.entity.VideoComment;
import com.zking.repository.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("CommentService")
    public class CommentServiceImpl implements  CommentService{
        @Autowired
        CommentDao commentDao;
        @Override
        public List<VideoComment> findAll(){
            return commentDao.findAll();
        }
        @Override
        public VideoComment saveComment(VideoComment videoComment){
            VideoComment c1 = commentDao.save(videoComment);
            return c1;
        }
        @Override
    public void deletecomment(int comment_id){
            commentDao.delete(comment_id);
        }
    }

