package com.sparta.post.dto;

import com.sparta.post.domain.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// Password가 보이지 않게 설정한 Dto
@RequiredArgsConstructor
@Getter
@Setter
public class PostDataDto {
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostDataDto(Post post){
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
