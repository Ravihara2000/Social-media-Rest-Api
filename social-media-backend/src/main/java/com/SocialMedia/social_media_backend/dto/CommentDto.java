package com.SocialMedia.social_media_backend.dto;

import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

public class CommentDto {
    private long id;


    private String content;


    private Timestamp createdAt;


    private Timestamp updatedAt;


    private Post post;


    private User user;
}
