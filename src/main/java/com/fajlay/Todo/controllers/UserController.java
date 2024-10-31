package com.fajlay.Todo.controllers;

import com.fajlay.Todo.dtos.UserDto;
import com.fajlay.Todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> CreateUser (@RequestBody UserDto userDto){
        System.out.println("I am hitting...");
        UserDto user = userService.createUser(userDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> GetAllUser (){
        List<UserDto> users = userService.getAllUser();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> GetUserByID(@PathVariable Long id){
        UserDto userDto = this.userService.getUserByID(id);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<UserDto> UpdateUser(@PathVariable Long id, UserDto userDto){
        UserDto  user = this.userService.updateUser(userDto, id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);

        return new ResponseEntity<>("",HttpStatus.OK);
    }



}
