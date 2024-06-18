package com.SocialMedia.social_media_backend.service;

import com.SocialMedia.social_media_backend.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment createComment(Long userId, Long postId, String content);
}
