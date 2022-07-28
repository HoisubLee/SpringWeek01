package com.sparta.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Post의 내용을 전달 받을 때 사용하는 Dto
@RequiredArgsConstructor
@Getter
@Setter
public class PostRequestDto {
    private final String title;
    private final String author;
    private final String password;
    private final String content;
}
