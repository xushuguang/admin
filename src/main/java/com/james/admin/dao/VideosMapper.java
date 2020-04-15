package com.james.admin.dao;

import com.james.admin.domain.Videos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideosMapper {

    void addVideos(Videos videos);

    List<Videos> selectAllVideos();

    List<Videos> selectVideosByUser(Long userId);
}
