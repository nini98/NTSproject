package com.yonghyeon.ntsproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class PostSaveRequest {

    @Size(max = 500)
    @NotBlank
    private final String title;
    @Size(max = 500)
    @NotBlank
    private final String content;
    @NotBlank
    private final String author;

}
