package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostResponseDto {
    private int postId;
    private String contents;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long commentCount;
    private int userId;



    public PostResponseDto(Post post, int userId) { // 데이터 저장
        this.postId = post.getPostId();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.userId= userId;

    }

    public PostResponseDto(String title, String contents, long commentCount,
                           LocalDateTime createdAt, LocalDateTime updatedAt,
                           int postId, int userId) {
        this.title = title;
        this.contents = contents;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.postId = postId;
        this.userId = userId;
    }

}
