package com.fajlay.Todo.repositories;

import com.fajlay.Todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositories extends JpaRepository<Todo, Long> {
}
