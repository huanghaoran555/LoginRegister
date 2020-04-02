package com.zking.Service;

import com.zking.entity.VideoComment;
import java.util.List;

public interface CommentService {
    //查询所有评论
List<VideoComment> findAll();
    //保存评论
    VideoComment saveComment(VideoComment videoComment);
    //根据id删除评论
    void deletecomment(int comment_id);
}
