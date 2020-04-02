package com.zking.repository;

import com.zking.entity.VideoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CommentDao extends JpaRepository<VideoComment,Integer> , JpaSpecificationExecutor<VideoComment> {
    @Query(value ="select * from video_comment c ,video_entity v where c.video_id=v.video_id",nativeQuery = true)
    List<VideoComment> findByVideo_id(int Video_id);
}
