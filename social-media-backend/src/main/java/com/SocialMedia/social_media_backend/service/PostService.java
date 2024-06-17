package com.SocialMedia.social_media_backend.service;

import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;

import java.util.List;

public interface PostService {
    Post createPost(Long userId, String content);

    List<PostDto> getAllPosts();
}
