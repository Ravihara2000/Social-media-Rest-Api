package com.SocialMedia.social_media_backend.service;

import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    Post createPost(Long userId, String content);

    List<PostDto> getAllPosts();

    List<PostDto> getPostById(Long postId);
}
