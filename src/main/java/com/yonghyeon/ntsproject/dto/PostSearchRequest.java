package com.yonghyeon.ntsproject.dto;

import com.yonghyeon.ntsproject.constant.PostSearchType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class PostSearchRequest {
    @NotNull
    private final PostSearchType searchType;
    private final String searchContent;
    @NotNull
    private final Long startLimit;
    @NotNull
    private final Long endLimit;

}
