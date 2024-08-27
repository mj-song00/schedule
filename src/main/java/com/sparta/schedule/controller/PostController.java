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

    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return postService.create(requestDto);
    }

    @GetMapping("")
    public Page<PostResponseDto> getPosts(
            @RequestParam(defaultValue ="0") int page,
            @RequestParam(defaultValue ="10") int size) {

        Pageable pageable = PageRequest.of(page,size);
        return this.postService.getPosts(pageable);
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
