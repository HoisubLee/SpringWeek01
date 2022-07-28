package com.sparta.assignment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PostRequestDto {
    private final String title;
    private final String author;
    private final String password;
    private final String contents;
}
