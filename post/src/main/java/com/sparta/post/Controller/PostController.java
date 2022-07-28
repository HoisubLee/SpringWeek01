package com.sparta.post.Controller;

import com.sparta.post.Service.PostService;
import com.sparta.post.domain.Post;
import com.sparta.post.dto.PostPasswordDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostDataDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    // 전체 게시글 목록 조회
    @GetMapping("/api/post")
    public PostResponseDto<List<PostDataDto>> getPost() {
        return new PostResponseDto<>(true, postService.findAll(),null);
    }

    // 게시글 조회
    @GetMapping("/api/post/{id}")
    public PostResponseDto<PostDataDto> getPostOne(@PathVariable Long id) {
        return new PostResponseDto<>(true, postService.find(id), null);
    }

    // 게시글 작성
    @PostMapping("/api/post")
    public PostResponseDto<PostDataDto> createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        PostDataDto dataDto = new PostDataDto(post);
        return new PostResponseDto<>(true, dataDto,null);
    }

    // 게시글 비밀번호 확인
    @PostMapping("/api/post/{id}")
    public PostResponseDto<Boolean> findPassword(@PathVariable Long id, @RequestBody PostPasswordDto passwordDto) {
        boolean b = postService.findPassword(id, passwordDto);
        return new PostResponseDto<>(true, b,null);
    }

    // 게시글 수정
    @PutMapping("/api/post/{id}")
    public PostResponseDto<PostDataDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return new PostResponseDto<>(true, new PostDataDto(postService.update(id, requestDto)), null);
    }

    // 게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public PostResponseDto<Boolean> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return new PostResponseDto<>(true, true,null);
    }

    // 출력 예외처리
    @ExceptionHandler(Exception.class)
    public PostResponseDto<Object> handleE(Exception e){
        return new PostResponseDto<>(false,null,e.getMessage());
    }
}