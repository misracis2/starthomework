package com.example.starthomework.Service;

import com.example.starthomework.Dto.PostDeleteDto;
import com.example.starthomework.Dto.PostRequestDto;
import com.example.starthomework.Dto.PostResponseDto;
import com.example.starthomework.Entity.Post;
import com.example.starthomework.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.System.out;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto); //테이블에 row를 하나 생성한 것
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    public PostResponseDto getpost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("게시물이 존재하지 않습니다")
    );
        return new PostResponseDto(post);
    }

    //findByIdAndPassword로 id, password 일치여부 확인, find...의 정체는 무엇이지?
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = (Post) postRepository.findByIdAndPassword(id, postRequestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다") //해당 게시물 존재 여부 확인
        );
        post.update(postRequestDto);
        //메모과제에선 왜 save없이 수정이 됐을까
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    public PostDeleteDto deletePost(Long id, PostRequestDto postRequestDto) {
        Post post = (Post) postRepository.findByIdAndPassword(id, postRequestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다") //해당 게시물 존재 여부 확인
        );
        postRepository.deleteById(id);
        boolean result = true;
        return new PostDeleteDto(result);
    }
}
