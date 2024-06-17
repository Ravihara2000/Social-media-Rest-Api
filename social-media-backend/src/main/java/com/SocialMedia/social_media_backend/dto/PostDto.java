package com.SocialMedia.social_media_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {


    private Long userId;


    private String content;

}
