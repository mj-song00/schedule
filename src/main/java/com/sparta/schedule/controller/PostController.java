package com.sparta.schedule.controller;

import com.sparta.schedule.dto.PostRequestDto;
import com.sparta.schedule.dto.PostResponseDto;
import com.sparta.schedule.entity.Post;
import com.sparta.schedule.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return postService.create(requestDto);
    }

    @GetMapping("")
    public List<Post> getAllPosts(){
        return this.postService.getPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable int id){
        return this.postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable int id, @RequestBody PostRequestDto requestDto){
        return this.postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public PostResponseDto deletePost(@PathVariable int id){
        return this.postService.deletePost(id);
    }
}
