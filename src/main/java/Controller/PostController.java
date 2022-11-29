package Controller;

import Dto.PostRequestDto;
import Entity.Post;
import Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public ModelAndView home()
    {
        return new ModelAndView("index");
    }

    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {

        return PostService.createPost(postRequestDto);
    }





}