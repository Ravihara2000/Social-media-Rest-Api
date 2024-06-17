package com.SocialMedia.social_media_backend.repository;

import com.SocialMedia.social_media_backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
