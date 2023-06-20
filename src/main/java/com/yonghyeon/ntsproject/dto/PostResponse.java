package com.yonghyeon.ntsproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final String regDate;

}
