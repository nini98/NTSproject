package com.yonghyeon.ntsproject.repository;

import com.yonghyeon.ntsproject.dto.PostResponse;
import com.yonghyeon.ntsproject.dto.PostSaveRequest;
import com.yonghyeon.ntsproject.dto.PostSearchRequest;
import com.yonghyeon.ntsproject.dto.PostUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostRepository {

    long findAllCnt();

    List<PostResponse> findAll(PostSearchRequest request);

    PostResponse findById(Long id);

    long findByTitleCnt(String title);

    List<PostResponse> findByTitle(PostSearchRequest request);

    long findByContentCnt(String content);

    List<PostResponse> findByContent(PostSearchRequest request);

    boolean exist(Long id);

    long regist(PostSaveRequest request);

    long modify(PostUpdateRequest request);

    long remove(Long id);
}
