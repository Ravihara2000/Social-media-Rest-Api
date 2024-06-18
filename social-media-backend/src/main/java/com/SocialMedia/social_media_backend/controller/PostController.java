package com.SocialMedia.social_media_backend.controller;

import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.dto.PostWithCommentDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        Post post = postService.createPost(postDto.getUserId(), postDto.getContent());
        PostDto postResponseDto = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok(postResponseDto);
    }

    @GetMapping
    public List<PostDto> getAllPost(){
        List<PostDto> allPost =postService.getAllPosts();
        return allPost;
    }

    @GetMapping(path = "/get-by-id",params = "id")
    public List<PostDto> getAllPostById(@RequestParam(value = "id")long postId){
        List<PostDto> allPostById = postService.getPostById(postId);
        return allPostById;
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostWithCommentDto> getPostWithComment(@PathVariable Long postId){
        PostWithCommentDto postWithCommentDto= postService.getPostWithComment(postId);
        return ResponseEntity.ok(postWithCommentDto);
    }
}
