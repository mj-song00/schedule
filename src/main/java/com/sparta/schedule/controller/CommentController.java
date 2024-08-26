package com.sparta.schedule.controller;

import com.sparta.schedule.dto.CommentRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/{postId}")
    public CommentResponseDto createComment(@PathVariable int postId, @RequestBody CommentRequestDto request){
       return commentService.createComment(postId, request);
    }

    @GetMapping("")
    public List<Comment> getAllComment(){
        return this.commentService.getComments();
    }

    @PutMapping("/{commentId}")
    public CommentResponseDto updateComment(@PathVariable int commentId, @RequestBody CommentRequestDto requestDto){
        return this.commentService.updateComment(commentId, requestDto);
    }

    @DeleteMapping("/{commentId}")
    public CommentResponseDto deleteComment(@PathVariable int commentId){
        return this.commentService.deleteComment(commentId);
    }
}
