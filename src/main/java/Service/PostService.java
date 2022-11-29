package Service;

import Dto.PostRequestDto;
import Entity.Post;
import Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    @Transactional
    public Post createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto); //테이블에 row를 하나 생성한 것
        postRepository.save(post);
        return post;
    }

/*    public List<Post> getPost() {
        return postRepository.findById();
    }*/
}
