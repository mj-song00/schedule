package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="user_posts")
@NoArgsConstructor
public class UserPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer upId;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;


    public UserPosts(User user, Post post) {
        this.user = user;
        this.post = post;
        this.createdAt =  LocalDateTime.now();
        this.updatedAt =  LocalDateTime.now();
    }
}
