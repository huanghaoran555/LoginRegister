package com.zking.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
/**
 * 视频评论
 */
@Entity
public class VideoComment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int comment_id;
    private String comment_info;
    private int Video_id;
    private int uid;
    private String comment_time;

    public VideoComment(){
    }

    public VideoComment(int comment_id,String comment_info,int Video_id,int uid,String comment_time){
        this.comment_id=comment_id;
        this.comment_info=comment_info;
        this.comment_time=comment_time;
        this.Video_id=Video_id;
        this.uid=uid;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_info() {
        return comment_info;
    }

    public void setComment_info(String comment_info) {
        this.comment_info = comment_info;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public int getVideo_id() {
        return Video_id;
    }

    public void setVideo_id(int Video_id) {
        this.Video_id = Video_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
@Override
    public String toString(){
    return "VideoComment{" +
            "comment_id=" + comment_id +
            ", comment_info='" + comment_info + '\'' +
            ", comment_time='" + comment_time + '\'' +
            ", Video_id='" + Video_id + '\'' +
            ", uid=" + uid +
            '}';
}
}
