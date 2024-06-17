package com.SocialMedia.social_media_backend.service;

import com.SocialMedia.social_media_backend.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String saveUser(UserDto userDto);

    List<UserDto> getAllUsers();
}
