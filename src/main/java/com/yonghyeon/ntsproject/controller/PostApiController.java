package com.yonghyeon.ntsproject.controller;

import com.yonghyeon.ntsproject.dto.*;
import com.yonghyeon.ntsproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/posts/cnt")
    public CountResponse getCnt(@Valid PostSearchRequest request) {
        return postService.findTotalCnt(request);
    }

    @GetMapping("/api/posts/list")
    public List<PostResponse> getList(@Valid PostSearchRequest request) {
        return postService.find(request);
    }

    @PostMapping("/api/posts")
    public SimpleResponse regist(@RequestBody @Valid PostSaveRequest request) {
        postService.regist(request);

        return new SimpleResponse(true);
    }

    @GetMapping("/api/posts/{id}")
    public PostResponse getPost(@PathVariable Long id) {

        return postService.findById(id);
    }

    @PutMapping("/api/posts/{id}")
    public SimpleResponse modify(@RequestBody @Valid PostUpdateRequest request) {
        postService.modify(request);

        return new SimpleResponse(true);
    }

    @DeleteMapping("/api/posts/{id}")
    public SimpleResponse remove(@PathVariable Long id) {
        postService.remove(id);

        return new SimpleResponse(true);
    }

}
