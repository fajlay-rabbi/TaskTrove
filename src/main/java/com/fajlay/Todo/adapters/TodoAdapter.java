package com.fajlay.Todo.adapters;

import com.fajlay.Todo.dtos.TodoDto;
import com.fajlay.Todo.entities.Categories;
import com.fajlay.Todo.entities.Todo;
import com.fajlay.Todo.entities.User;
import com.fajlay.Todo.repositories.CategoriesRepositories;
import com.fajlay.Todo.repositories.UserRepositories;

public class TodoAdapter {
    public static Todo toTodoEntity (TodoDto todoDto, UserRepositories userRepositories, CategoriesRepositories categoriesRepositories){
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());
        todo.setPriority(todoDto.getPriority());
        todo.setDueDate(todoDto.getDueDate());

        User user = userRepositories
                .findById(todoDto.getUserId())
                        .orElseThrow(() -> new RuntimeException("No user found!"));

        Categories categories = categoriesRepositories.findByType(todoDto.getCategory())
                        .orElseGet(() -> {
                            Categories newCategories = new Categories();
                            newCategories.setType(todoDto.getCategory());

                            return categoriesRepositories.save(newCategories);
                        });

        todo.setUser(user);
        todo.setCategory(categories);

        return todo;
    }

    public static TodoDto toTodoDto (Todo todo){
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setStatus(todo.getStatus());
        todoDto.setPriority(todo.getPriority());
        todoDto.setDueDate(todo.getDueDate());
        todoDto.setUserId(todo.getUser().getId());
        todoDto.setCategory(todo.getCategory().getType());

        return todoDto;
    }

    public static Todo updateTodoEntity(TodoDto todoDto, Todo todo){
        if (todoDto.getTitle() != null){
            todo.setTitle(todoDto.getTitle());
        }
        if (todoDto.getDescription() != null) {
            todo.setDescription(todoDto.getDescription());
        }
        if (todoDto.getStatus() != null){
            todo.setStatus(todoDto.getStatus());
        }
        if (todoDto.getPriority() != null){
            todo.setPriority(todoDto.getPriority());
        }

        return todo;
    }
}
