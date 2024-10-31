package com.fajlay.Todo.services;

import com.fajlay.Todo.adapters.TodoAdapter;
import com.fajlay.Todo.dtos.TodoDto;
import com.fajlay.Todo.entities.Todo;
import com.fajlay.Todo.repositories.CategoriesRepositories;
import com.fajlay.Todo.repositories.TodoRepositories;
import com.fajlay.Todo.repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    public final TodoRepositories todoRepositories;
    public final UserRepositories userRepositories;
    public final CategoriesRepositories categoriesRepositories;
    public TodoService(TodoRepositories todoRepositories, UserRepositories userRepositories, CategoriesRepositories categoriesRepositories) {
        this.todoRepositories = todoRepositories;
        this.userRepositories = userRepositories;
        this.categoriesRepositories = categoriesRepositories;
    }

    public TodoDto createTodo (TodoDto todoDto){
        Todo todo = TodoAdapter.toTodoEntity(todoDto, userRepositories, categoriesRepositories);
        todo = todoRepositories.save(todo);

        return TodoAdapter.toTodoDto(todo);
    }

    public List<TodoDto> getAllTodo(){
        return this.todoRepositories.findAll()
                .stream()
                .map(TodoAdapter::toTodoDto)
                .collect(Collectors.toList());
    }

    public TodoDto getTodoById(Long id){
        Todo todo = new Todo();
        todo = this.todoRepositories.findById(id).orElseThrow(() -> new RuntimeException("No ID found!!"));

        return TodoAdapter.toTodoDto(todo);
    }

    public TodoDto updateTodo(TodoDto todoDto, Long id){
        Todo todo = this.todoRepositories.findById(id).orElseThrow(()-> new RuntimeException("No Such Todo found!"));
        TodoAdapter.updateTodoEntity(todoDto, todo);
        this.todoRepositories.save(todo);

        return TodoAdapter.toTodoDto(todo);
    }

    public void deleteTodo(Long id){
        this.todoRepositories.deleteById(id);
    }
}
