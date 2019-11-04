package com.zking.entity;

import javax.persistence.*;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer video_id;
    private String movie_name;
    private String description;
    private String movie_type;
    private Integer play_num;
    private Integer comment_num;
    private String upDate;
    private String Path;

    public VideoEntity(Integer video_id, String movie_name, String description, String movie_type, Integer play_num, Integer comment_num,String upDate,String Path) {
        this.video_id = video_id;
        this.movie_name = movie_name;
        this.description = description;
        this.movie_type = movie_type;
        this.play_num = play_num;
        this.comment_num = comment_num;
        this.upDate=upDate;
        this.Path=Path;
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
    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }
    @Basic
    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }
    @Basic
    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }
    @Basic
    public String getPath(){
        return Path;
    }
    public void setPath(String Path){this.Path=Path;}

    @Override
    public String toString() {
        return "VideoEntity{" +
                "video_id=" + video_id +
                ", movie_name='" + movie_name + '\'' +
                ", description='" + description + '\'' +
                ", movie_type='" + movie_type + '\'' +
                ", play_num=" + play_num +
                ", comment_num=" + comment_num +
                ", upDate=" + upDate +
                ", Path=" + Path +
                '}';
    }
}
