package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private int postId;
    private String contents;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private long commentCount;

    public PostResponseDto(Post post) { // 데이터 저장
        this.postId = post.getPostId();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.username = post.getUsername();
    }

    public PostResponseDto(String title, String contents, long commentCount, LocalDateTime createdAt, LocalDateTime updatedAt, String username , int postId){
        this.title = title;
        this.contents = contents;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.username = username;
        this.postId = postId;
    }


}
