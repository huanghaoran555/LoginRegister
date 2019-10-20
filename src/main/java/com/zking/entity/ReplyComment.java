package com.zking.entity;

import lombok.Data;

/**
 * 二级回复评论
 */
@Data
public class ReplyComment {
    private Integer id;
    private int articleId;
    private int commentId;
    //private int commentUserId;//
    private int replyUserId;//创建这条回复的id
    private UserEntity user;//读取评论的时候需要读取这个user信息
    private int repliedUserId;//这条回复的@人的id
    private String content;
    private String createTime;
    public ReplyComment(){}
    public ReplyComment(int articleId,int commentId,int replyUserId,int repliedUserId,String content){
        this.articleId=articleId;
        this.commentId=commentId;
        this.replyUserId=replyUserId;
        this.repliedUserId=repliedUserId;
        this.content=content;
    }
}
