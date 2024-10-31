package com.fajlay.Todo.repositories;

import com.fajlay.Todo.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepositories extends JpaRepository<Categories, Long> {
    boolean existsByType(String type);

    Optional<Categories> findByType(String type);

//    List<Categories> findByType(String type);


}
