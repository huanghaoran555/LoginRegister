package com.zking.repository;

import com.zking.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface VideoDao extends JpaRepository<VideoEntity,Integer>, JpaSpecificationExecutor<VideoEntity> {
    @Query(value = "select * from video_entity where movie_name=?",nativeQuery = true)
    List<VideoEntity> findByMovie_name( String movie_name);
    @Query(value = "select * from video_entity where video_id=?",nativeQuery = true)
    List<VideoEntity> findById(Integer video_id);
    @Query(value = "select * from video_entity where Path=?",nativeQuery = true)
    VideoEntity findByPath(String Path);
}
