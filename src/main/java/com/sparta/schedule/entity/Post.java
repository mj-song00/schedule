package com.sparta.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.schedule.dto.PostRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="post")
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Integer postId;

    private String password;
    private String username;
    private String title;
    private String contents;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public void addCommentList(Comment comment){
        this.commentList.add(comment);
        comment.setPost(this);
    }

    public Post(PostRequestDto requestDto) { //데이터 저장
        this.password= requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.updatedAt = LocalDateTime.now();
    }

}
