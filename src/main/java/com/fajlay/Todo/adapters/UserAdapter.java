package com.fajlay.Todo.adapters;

import com.fajlay.Todo.dtos.UserDto;
import com.fajlay.Todo.entities.User;

public class UserAdapter {
    public static User toUserEntity(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public static User updateUserEntity(UserDto userDto, User user){
        if (userDto.getUsername() != null){
            user.setUsername(user.getUsername());
        }
        if (userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }

        return user;
    }
}
