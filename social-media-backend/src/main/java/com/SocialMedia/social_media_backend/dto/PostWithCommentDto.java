package com.SocialMedia.social_media_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWithCommentDto {
    private Long id;
    private String content;
    private List<CommentDto> comments;
}
