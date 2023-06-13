package com.yonghyeon.ntsproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class ExceptionResponse {
    private final Date timestamp;
    private final String message;
    private final String details;

}
