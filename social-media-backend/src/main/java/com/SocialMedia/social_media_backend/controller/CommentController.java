package com.SocialMedia.social_media_backend.controller;

import com.SocialMedia.social_media_backend.dto.CommentDto;
import com.SocialMedia.social_media_backend.entity.Comment;
import com.SocialMedia.social_media_backend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentService commentService;

   @PostMapping("/save")
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto commentDto){
        Comment comment= commentService.createComment(commentDto.getUserId(),commentDto.getPostId(),commentDto.getContent());
        CommentDto commentResponseDto =modelMapper.map(comment,CommentDto.class);
        return ResponseEntity.ok(commentResponseDto);
    }
}
