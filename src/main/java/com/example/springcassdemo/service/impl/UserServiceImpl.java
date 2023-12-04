package com.example.springcassdemo.service.impl;

import com.example.springcassdemo.Util.AppUtils;
import com.example.springcassdemo.dto.UserDto;
import com.example.springcassdemo.entity.User;
import com.example.springcassdemo.repository.UserRepository;
import com.example.springcassdemo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("error"));
        userRepository.deleteById(user.getId());
    }

    @PostConstruct
    public void initialSave() {
        List<User> users = new ArrayList<>();
        users.add(new User(6437, "henry", "irvine", 32));
        users.add(new User(5362, "jenny", "irvine", 31));
        users.add(new User(3964, "Mark", "anaham", 33));
        users.add(new User(4405, "meizi", "chino hills", 28));
        userRepository.saveAll(users);
    }

    @Override
    public List<UserDto> getALLUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(u -> AppUtils.entityToDto(u)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("error"));
        return AppUtils.entityToDto(user);
    }
    @Override
    public void saveUser(UserDto userDto) {
        User user = AppUtils.dtoToEntity(userDto);
        userRepository.save(user);
    }
}
