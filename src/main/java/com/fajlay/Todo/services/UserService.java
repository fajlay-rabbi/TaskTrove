package com.fajlay.Todo.services;

import com.fajlay.Todo.adapters.UserAdapter;
import com.fajlay.Todo.dtos.UserDto;
import com.fajlay.Todo.entities.User;
import com.fajlay.Todo.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    public final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public UserDto createUser(UserDto userDto) {
        User user = UserAdapter.toUserEntity(userDto);

        user = this.userRepositories.save(user);

        return UserAdapter.toUserDto(user);
    }

    public List<UserDto> getAllUser() {
        List<UserDto> users = userRepositories.findAll()
                .stream()
                .map(UserAdapter::toUserDto)
                .collect(Collectors.toList());

        return users;
    }

    public UserDto getUserByID(Long id) {
        User user = this.userRepositories.findById(id).orElseThrow(() -> new RuntimeException("No user found!"));

        return UserAdapter.toUserDto(user);
    }

    public UserDto updateUser(UserDto userDto, Long id) {
        User user = this.userRepositories
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No user Found"));

        user = UserAdapter.updateUserEntity(userDto, user);
        this.userRepositories.save(user);

        return UserAdapter.toUserDto(user);
    }

    public void deleteUser(Long id) {
        this.userRepositories.deleteById(id);
    }
}
