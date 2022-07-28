package com.sparta.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Password값만 확인하기 위해 사용하는 Dto
@RequiredArgsConstructor
@Getter
@Setter
public class PostPasswordDto {
    private final String password;
}
