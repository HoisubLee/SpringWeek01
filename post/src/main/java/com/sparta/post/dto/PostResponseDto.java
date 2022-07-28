package com.sparta.post.dto;

import lombok.Getter;
import lombok.Setter;

// 출력용 Dto
@Getter
@Setter
public class PostResponseDto<T> {
    private boolean success;
    private T data;
    private String error;

    public PostResponseDto(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
