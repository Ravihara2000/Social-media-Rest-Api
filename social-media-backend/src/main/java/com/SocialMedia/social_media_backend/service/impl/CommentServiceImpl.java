package com.SocialMedia.social_media_backend.service.impl;

import com.SocialMedia.social_media_backend.entity.Comment;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;
import com.SocialMedia.social_media_backend.repository.CommentRepo;
import com.SocialMedia.social_media_backend.repository.PostRepo;
import com.SocialMedia.social_media_backend.repository.UserRepo;
import com.SocialMedia.social_media_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;
    @Override
    public Comment createComment(Long userId, Long postId, String content) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment= new Comment();
        comment.setUser(user);
        comment.setContent(content);
        comment.setPost(post);
        return commentRepo.save(comment);

    }
    public Post createPost(Long userId, String content) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setUser(user);
        post.setContent(content);
        return postRepo.save(post);
    }
}
