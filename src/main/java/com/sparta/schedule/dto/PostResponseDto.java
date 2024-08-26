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

    public PostResponseDto(Post post) { // 데이터 저장
        this.postId = post.getPostId();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreated_at();
        this.updatedAt = post.getUpdated_at();
    }
}
