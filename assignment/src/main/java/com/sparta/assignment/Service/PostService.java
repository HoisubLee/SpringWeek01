package com.sparta.assignment.Service;

import com.sparta.assignment.domain.Post;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }
}
