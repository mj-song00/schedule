package com.sparta.schedule.controller;


import com.sparta.schedule.dto.UserRequestDto;
import com.sparta.schedule.dto.UserResponseDto;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        System.out.println("username = " + requestDto.getUsername());
        System.out.println("userEmail = " + requestDto.getEmail());
       return userService.createUser(requestDto);
    }

    //전체유저 조회
    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

    // 개인정보
    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable int userId){
        return userService.getInfo(userId);
    }

    // 개인정보 수정
    @PutMapping("/{userId}")
    public UserResponseDto updateInfo(@PathVariable int userId, @RequestBody UserRequestDto requestDto){
        return userService.updateInfo(userId, requestDto);
    }

    @DeleteMapping("/{userId}")
    public UserResponseDto deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
}
