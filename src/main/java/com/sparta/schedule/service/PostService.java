package com.sparta.schedule.service;

import com.sparta.schedule.dto.PostRequestDto;
import com.sparta.schedule.dto.PostResponseDto;
import com.sparta.schedule.entity.Post;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.entity.UserPosts;
import com.sparta.schedule.repository.PostRepository;
import com.sparta.schedule.repository.UserPostsRepository;
import com.sparta.schedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PostService {


    private final PostRepository postRepository;
    private final UserPostsRepository userPostsRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserPostsRepository userPostsRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userPostsRepository = userPostsRepository;
        this.userRepository = userRepository;
    }

    public PostResponseDto create(int userId, PostRequestDto requestDto) {
        User user = findUser(userId);
        Post post = new Post(requestDto);
        post.setUser(user);

        Post savePost = postRepository.save(post);

        PostResponseDto postResponseDto = new PostResponseDto(savePost, userId);

        return postResponseDto;
    }


    public Page<PostResponseDto> getPosts(Pageable pageable){

        return postRepository.findAllPostsWithCommentCount(pageable);

    }

    public PostResponseDto getPostById(int postId){
        Post post = findPost(postId);

        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(int postId, int userId, PostRequestDto requestDto){
        Post post = findPost(postId);
        User user = findUser(userId);

        post.update(requestDto);
        UserPosts up = new UserPosts(user, post);
        userPostsRepository.save(up);
        return new PostResponseDto(post, userId);
    }

    public PostResponseDto deletePost(int userId){
        Post post = findPost(userId);
        postRepository.delete(post);
        return new PostResponseDto(post, userId);
    }

    private Post findPost(int id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 post는 존재하지 않습니다.")
        );
    }

    private User findUser(int userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 userId는 존재하지 않습니다.")
        );
    }
}
