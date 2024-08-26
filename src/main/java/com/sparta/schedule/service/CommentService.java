package com.sparta.schedule.service;

import com.sparta.schedule.dto.CommentRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Post;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository ){
        this.commentRepository = commentRepository;
        this.postRepository= postRepository;

    }

    public CommentResponseDto createComment(int postId, CommentRequestDto requestDto){
        Post post = findPost(postId);

        Comment comment = new Comment(requestDto);

        post.addCommentList(comment);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    public List<Comment>  getComments(){
        List<Comment> comment = commentRepository.findAll();
        return comment;
    }

    @Transactional
    public CommentResponseDto updateComment(int commentId, CommentRequestDto requestDto){
        Comment comment = findComment(commentId);

        comment.update(requestDto);
        return new CommentResponseDto(comment);
    }

    public CommentResponseDto deleteComment(int commentId){
        Comment comment = findComment(commentId);
        commentRepository.delete(comment);
        return new CommentResponseDto(comment);
    }





    private Post findPost(int postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("선택한 post는 존재하지 않습니다.")
        );
    }


    private Comment findComment(int commentId) {
        return commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }


}
