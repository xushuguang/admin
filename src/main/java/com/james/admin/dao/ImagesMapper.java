package com.james.admin.dao;

import com.james.admin.domain.Images;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagesMapper {

    void addImages(Images images);

    List<Images> selectAllImages();

    List<Images> selectImagesByUser(Long userId);
}
