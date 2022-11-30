package com.example.starthomework.Controller;

import com.example.starthomework.Dto.PostDeleteDto;
import com.example.starthomework.Dto.PostRequestDto;
import com.example.starthomework.Dto.PostResponseDto;
import com.example.starthomework.Entity.Post;
import com.example.starthomework.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public ModelAndView home()
    {
        return new ModelAndView("index");
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @GetMapping("/post")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    //선택한 게시글 조회
    @GetMapping("/post/{id}") //id값을 pathVariable로 받아서 해당 게시글 불러오기
    public PostResponseDto getPost(@PathVariable Long id) { // 반환 타입은 Dto, password는 제외해서 반환
        return postService.getpost(id);}

    @PutMapping("/post/update/{id}") //id값으로 수정할 게시글을 찾는다
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    //선택한 게시글 삭제
    @DeleteMapping("/post/delete/{id}")
    public PostDeleteDto deletePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        return postService.deletePost(id, postRequestDto);
    }





}
