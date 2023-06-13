package com.yonghyeon.ntsproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class PostUpdateRequest {

    @NotNull
    private final Long id;
    @Size(max = 500)
    @NotBlank
    private final String title;
    @Size(max = 500)
    @NotBlank
    private final String content;
}
