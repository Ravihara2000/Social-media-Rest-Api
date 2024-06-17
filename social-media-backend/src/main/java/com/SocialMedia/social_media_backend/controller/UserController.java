package com.SocialMedia.social_media_backend.controller;

import com.SocialMedia.social_media_backend.dto.UserDto;
import com.SocialMedia.social_media_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/save")
    public String saved(@RequestBody UserDto userDto){
        String messege=userService.saveUser(userDto);
        return "saved";
    }

    @GetMapping("/get-all")
    public List<UserDto> getAllUser(){
        List<UserDto> allUsers= userService.getAllUsers();
        return allUsers;
    }
}
