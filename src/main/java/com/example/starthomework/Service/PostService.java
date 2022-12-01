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
    @Transactional//수정된 데이터를 비교해서 저장해주는 역할(JPA 더티체킹)
    //findByIdAndPassword로 id, password 일치여부 확인, find...의 정체는 무엇이지?
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findByIdAndPassword(id, postRequestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다") //해당 게시물 존재 여부 확인
        );
        //1. 파라미터로 받은 id로 post를 찾아온다 findbyid
        //2. 찾아온 post의 비밀번호와 파라미터로 받은 비밀번호를 비교한다
        //3. 일치하면 게시글을 업데이트한다
        //4. 일치하지 않으면 예외를 발생시킨다
        post.update(postRequestDto);

        return new PostResponseDto(post);
    }

    public PostDeleteDto deletePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findByIdAndPassword(id, postRequestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다") //해당 게시물 존재 여부 확인
        );
        postRepository.deleteById(id);
        boolean result = true;
        return new PostDeleteDto(result);
    }
}
