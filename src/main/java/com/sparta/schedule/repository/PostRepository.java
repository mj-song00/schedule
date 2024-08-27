package com.sparta.schedule.repository;

import com.sparta.schedule.dto.PostResponseDto;
import com.sparta.schedule.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

  @Query("SELECT new com.sparta.schedule.dto.PostResponseDto(" +
          "p.title, p.contents, COUNT(c), p.createdAt, p.updatedAt, p.username, p.postId) " +
          "FROM Post p " +
          "LEFT JOIN p.commentList c " +
          "GROUP BY p.postId, p.title, p.contents, p.createdAt, p.updatedAt, p.username " +
          "ORDER BY p.updatedAt DESC")
  Page<PostResponseDto> findAllPostsWithCommentCount(Pageable pageable);
}
