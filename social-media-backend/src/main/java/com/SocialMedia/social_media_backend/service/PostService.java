package com.SocialMedia.social_media_backend.service;

import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.dto.PostWithCommentDto;
import com.SocialMedia.social_media_backend.dto.request.PostUpdateDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    Post createPost(Long userId, String content);

    List<PostDto> getAllPosts();

    List<PostDto> getPostById(Long postId);

    PostWithCommentDto getPostWithComment(Long postId);

    PostUpdateDto updatePost(PostUpdateDto postUpdateDto);

    String deletePost(Long postId);
}
