package com.example.springcassdemo.Util;

import com.example.springcassdemo.dto.UserDto;
import com.example.springcassdemo.entity.User;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
    public static  User dtoToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}
