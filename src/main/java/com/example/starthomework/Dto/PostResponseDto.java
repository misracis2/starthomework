package com.example.starthomework.Dto;


import com.example.starthomework.Entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String username;
    private String title;
    private String contents;

    public PostResponseDto(Post post) {
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.contents = post.getContent();
    }
}
