package com.fajlay.Todo.controllers;

import com.fajlay.Todo.dtos.TodoDto;
import com.fajlay.Todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){
        TodoDto todo = todoService.createTodo(todoDto);

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoDto>> Hello(){
        List<TodoDto> todos = todoService.getAllTodo();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id){
        TodoDto todo = new TodoDto();
        todo = todoService.getTodoById(id);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, TodoDto todoDto){
        TodoDto todo = new TodoDto();
        todo = todoService.updateTodo(todoDto, id);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
