package com.zking.entity;

import lombok.Data;
import java.util.List;
/**
 * 视频一级评论
 */
@Data
public class VideoComment {
    private Integer id;//主键id
    private int commentUserId;//创建该评论的用户id
    private UserEntity user;
    private int videoId;//评论的文章id
    private String content;//评论内容
    private String createTime;//评论的日期
    private List<ReplyComment> replyCommentList;
    public VideoComment(){}
    public VideoComment(int commentUserId,int videoId,String content){
        this.videoId=videoId;
        this.commentUserId=commentUserId;
        this.content=content;
    }
}
