package com.zking.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue
    private Integer video_id;
    private String movie_name;
    private String description;
    private String movie_type;
    private Integer playNum;
    private Integer commentNum;
    private String upDate;

    public VideoEntity(Integer video_id, String movie_name, String description, String movie_type, Integer playNum, Integer commentNum,String upDate) {
        this.video_id = video_id;
        this.movie_name = movie_name;
        this.description = description;
        this.movie_type = movie_type;
        this.playNum = playNum;
        this.commentNum = commentNum;
        this.upDate=upDate;
    }

    public VideoEntity() {
    }
@Basic
    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }
    @Basic
    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Basic
    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }
    @Basic
    public Integer getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }
    @Basic
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
    @Basic
    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "video_id=" + video_id +
                ", movie_name='" + movie_name + '\'' +
                ", description='" + description + '\'' +
                ", movie_type='" + movie_type + '\'' +
                ", playNum=" + playNum +
                ", commentNum=" + commentNum +
                ", upDate=" + upDate +
                '}';
    }
}
