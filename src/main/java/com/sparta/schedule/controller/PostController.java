package com.sparta.schedule.controller;

import com.sparta.schedule.dto.PostRequestDto;
import com.sparta.schedule.dto.PostResponseDto;
import com.sparta.schedule.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{userId}")
    public PostResponseDto createPost(@PathVariable int userId, @RequestBody PostRequestDto requestDto){
        return postService.create(userId, requestDto);
    }

    @GetMapping("")
    public Page<PostResponseDto> getPosts(
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue ="10") int size) {

        Pageable pageable = PageRequest.of(page,size);
        return postService.getPosts(pageable);
    }

    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable int id){
        return this.postService.getPostById(id);
    }

    @PutMapping("/{postId}/{userId}")
    public PostResponseDto updatePost(@PathVariable int postId, @PathVariable int userId, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(postId, userId, requestDto);
    }

    @DeleteMapping("/{id}")
    public PostResponseDto deletePost(@PathVariable int id){
        return this.postService.deletePost(id);
    }
}
