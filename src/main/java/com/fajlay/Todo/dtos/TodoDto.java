package com.fajlay.Todo.dtos;

import com.fajlay.Todo.util.Priority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private Boolean status; // true = complete, false = incomplete
    private Priority priority;
    private LocalDateTime dueDate;

    private Long userId;
    private String category;
}
