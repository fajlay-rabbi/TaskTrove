package com.fajlay.Todo.controllers;

import com.fajlay.Todo.dtos.CategoriesDto;
import com.fajlay.Todo.entities.Categories;
import com.fajlay.Todo.repositories.CategoriesRepositories;
import com.fajlay.Todo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoriesDto> createCategories(@RequestBody CategoriesDto request){
        CategoriesDto category = categoryService.createCategory(request);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoriesDto>> getAllCategories(){
        List<CategoriesDto> category = categoryService.getAllTodos();

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<CategoriesDto> updateCategory(@PathVariable Long id, @RequestBody CategoriesDto request){
        CategoriesDto category = categoryService.updateCategory(request, id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
