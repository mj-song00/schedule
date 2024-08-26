package com.sparta.schedule.service;

import com.sparta.schedule.dto.PostRequestDto;
import com.sparta.schedule.dto.PostResponseDto;
import com.sparta.schedule.entity.Post;
import com.sparta.schedule.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PostService {


    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto create(PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Post savePost = postRepository.save(post);

        PostResponseDto postResponseDto = new PostResponseDto(savePost);

        return postResponseDto;
    }

    public Page<Post> getPosts(Pageable pageable){

        return postRepository.findAllPostByOrderByUpdatedAtDesc(pageable);

    }

    public PostResponseDto getPostById(int id){
       return new PostResponseDto(findPost(id));

    }

    @Transactional
    public PostResponseDto updatePost(int id, PostRequestDto requestDto){
        Post post = findPost(id);

        post.update(requestDto);

        return new PostResponseDto(post);
    }

    public PostResponseDto deletePost(int id){
        Post post = findPost(id);
        postRepository.delete(post);
        return new PostResponseDto(post);
    }

    private Post findPost(int id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 post는 존재하지 않습니다.")
        );
    }
}
