package com.SocialMedia.social_media_backend.service.impl;

import com.SocialMedia.social_media_backend.dto.UserDto;
import com.SocialMedia.social_media_backend.entity.User;
import com.SocialMedia.social_media_backend.repository.UserRepo;
import com.SocialMedia.social_media_backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String saveUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        userRepo.save(user);
        return "saved successfully";
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        if (allUsers.size() > 0) {
            for (User user : allUsers) {
                UserDto userDto = modelMapper.map(user, UserDto.class);
                userDtoList.add(userDto);
            }
        }

        return userDtoList;
    }

}
