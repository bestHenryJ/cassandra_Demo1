package com.example.springcassdemo.controller;

import com.example.springcassdemo.dto.UserDto;
import com.example.springcassdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public ResponseEntity<?> getAllUser(){
        List<UserDto> allUser = userService.getALLUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/newUser")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseEntity<>("Add a user successfully !", HttpStatus.CREATED);
    }

}
