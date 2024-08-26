package com.sparta.schedule.entity;

import com.sparta.schedule.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name ="comment")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String contents;
    private String username;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;


    public Comment(CommentRequestDto requestDto) {//데이터 저장
        this.contents = requestDto.getContents();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.username = requestDto.getUsername();
    }

    public void update(CommentRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.updatedAt = LocalDateTime.now();
        this.username = requestDto.getUsername();
    }
}
