package com.yonghyeon.ntsproject.service;

import com.yonghyeon.ntsproject.constant.PostSearchType;
import com.yonghyeon.ntsproject.dto.*;
import com.yonghyeon.ntsproject.exception.NotFoundException;
import com.yonghyeon.ntsproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public CountResponse findTotalCnt(PostSearchRequest request) {
        PostSearchType searchType = request.getSearchType();
        String searchContent = request.getSearchContent();

        long postCnt = 0L;
        if (StringUtils.isBlank(searchContent)) {
            postCnt = postRepository.findAllCnt();
        } else {
            switch (searchType) {
                case TITLE:
                    postCnt = postRepository.findByTitleCnt(searchContent);
                    break;
                case CONTENT:
                    postCnt = postRepository.findByContentCnt(searchContent);
                    break;

            }
        }

        return new CountResponse(postCnt);
    }

    public List<PostResponse> find(PostSearchRequest request) {
        PostSearchType searchType = request.getSearchType();
        String searchContent = request.getSearchContent();

        List<PostResponse> lst = new ArrayList<>();

        if (StringUtils.isBlank(searchContent)) {
            lst = postRepository.findAll(request);
        } else {
            switch (searchType) {
                case TITLE:
                    lst = postRepository.findByTitle(request);
                    break;
                case CONTENT:
                    lst = postRepository.findByContent(request);
                    break;
            }
        }

        return lst;
    }

    public PostResponse findById(Long id) {
        PostResponse postResponse = postRepository.findById(id);

        if (postResponse == null) {
            throw new NotFoundException("post not found");
        }

        return postResponse;
    }


    //   데이터 변경 쿼리가 하나 뿐이라 굳이 @Transactional을 붙일 필요는 없다.
    public void regist(PostSaveRequest request) {
        postRepository.regist(request);
    }

    public void modify(PostUpdateRequest request) {

        if (!postRepository.exist(request.getId())) {
            throw new NotFoundException("post not found");
        }

        postRepository.modify(request);
    }

    public void remove(Long id) {

        if (!postRepository.exist(id)) {
            throw new NotFoundException("post not found");
        }

        postRepository.remove(id);
    }
}
