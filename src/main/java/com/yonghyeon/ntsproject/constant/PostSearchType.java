package com.yonghyeon.ntsproject.constant;

import lombok.Getter;

@Getter
public enum PostSearchType {
    TITLE("TITLE", "제목"),
    CONTENT("CONTENT", "내용");

    private final String value;
    private final String description;

    PostSearchType(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
