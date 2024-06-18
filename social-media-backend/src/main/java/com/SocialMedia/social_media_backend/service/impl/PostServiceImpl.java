package com.SocialMedia.social_media_backend.service.impl;

import com.SocialMedia.social_media_backend.dto.CommentDto;
import com.SocialMedia.social_media_backend.dto.PostDto;
import com.SocialMedia.social_media_backend.dto.PostWithCommentDto;
import com.SocialMedia.social_media_backend.dto.UserDto;
import com.SocialMedia.social_media_backend.dto.request.PostUpdateDto;
import com.SocialMedia.social_media_backend.entity.Post;
import com.SocialMedia.social_media_backend.entity.User;
import com.SocialMedia.social_media_backend.repository.PostRepo;
import com.SocialMedia.social_media_backend.repository.UserRepo;
import com.SocialMedia.social_media_backend.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Post createPost(Long userId, String content) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setUser(user);
        post.setContent(content);
        return postRepo.save(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepo.findAll();
        List<PostDto> postDtoList= new ArrayList<>();

        if (allPosts.size() > 0) {
            for (Post post : allPosts) {
                PostDto postDto = modelMapper.map(post, PostDto.class);
                postDtoList.add(postDto);
            }
        }

        return postDtoList;
    }



    @Override
    public List<PostDto> getPostById(Long userId) {
        List<Post> allPostsById = postRepo.findByUserId(userId);
        List<PostDto> postDtoListById = new ArrayList<>();

        if (!allPostsById.isEmpty()) {
            for (Post post : allPostsById) {
                PostDto postDto = modelMapper.map(post, PostDto.class);
                postDtoListById.add(postDto);
            }
        }

        return postDtoListById;
    }

    @Override
    public PostWithCommentDto getPostWithComment(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new RuntimeException("Post not found"));

        PostWithCommentDto postWithCommentDto=modelMapper.map(post,PostWithCommentDto.class);
        List<CommentDto> commentDtos=post.getComments().stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
        postWithCommentDto.setComments(commentDtos);

        return postWithCommentDto;
    }

    @Override
    public PostUpdateDto updatePost(PostUpdateDto postUpdateDto) {
        if(postRepo.existsById(postUpdateDto.getPostId())){
            Post post = postRepo.getReferenceById(postUpdateDto.getPostId());
            post.setContent(postUpdateDto.getContent());

            postRepo.save(post);
            return postUpdateDto;
        }else {
            throw new RuntimeException();
        }
    }

    }


