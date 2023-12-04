package com.example.springcassdemo.service;

import com.example.springcassdemo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    void saveUser(UserDto userDto);
    List<UserDto> getALLUser();
    UserDto getUserById(int id);
    void deleteUser(int id);
}
