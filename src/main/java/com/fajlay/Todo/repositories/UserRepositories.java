package com.fajlay.Todo.repositories;

import com.fajlay.Todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
}
