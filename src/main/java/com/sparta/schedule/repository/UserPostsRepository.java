package com.sparta.schedule.repository;

import com.sparta.schedule.entity.UserPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostsRepository extends JpaRepository<UserPosts, Integer> {

}
