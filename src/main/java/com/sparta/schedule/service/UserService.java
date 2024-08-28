package com.sparta.schedule.service;


import com.sparta.schedule.dto.UserRequestDto;
import com.sparta.schedule.dto.UserResponseDto;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto requestDto){

        User user = new User(requestDto);

        User saveUser  = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto(saveUser);

        return userResponseDto;

    }

    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public UserResponseDto getInfo(int userId){
        User user = findUser(userId);
        UserResponseDto userResponseDto = new UserResponseDto(user);

        return userResponseDto;
    }

    @Transactional
    public UserResponseDto updateInfo(int userId, UserRequestDto requestDto ){
        User user = findUser(userId);

        user.update(requestDto);

        return new UserResponseDto(user);
    }

    public UserResponseDto deleteUser(int userId){
        User user = findUser(userId);
        userRepository.delete(user);
        return new UserResponseDto(user);
    }

    private User findUser(int userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 userId는 존재하지 않습니다.")
        );
    }
}
