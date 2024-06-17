package com.SocialMedia.social_media_backend.controller;

import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody PostDto postDto) {
        Post post = postService.createPost(postDto.getUserId(), postDto.getContent());
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public List<PostDto> getAllPost(){
        List<PostDto> allPost =postService.getAllPosts();
        return allPost;
    }
}
