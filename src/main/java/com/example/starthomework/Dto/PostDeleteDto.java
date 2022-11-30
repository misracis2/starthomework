package com.example.starthomework.Dto;

import lombok.Getter;

@Getter
public class PostDeleteDto {
    private boolean deleteResult;

    public PostDeleteDto(boolean deleteResult){
        this.deleteResult = deleteResult;
    }
}
