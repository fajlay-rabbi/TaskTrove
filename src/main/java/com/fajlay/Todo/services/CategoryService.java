package com.fajlay.Todo.services;

import com.fajlay.Todo.adapters.CategoriesAdapter;
import com.fajlay.Todo.dtos.CategoriesDto;
import com.fajlay.Todo.entities.Categories;
import com.fajlay.Todo.repositories.CategoriesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoriesRepositories repositories;

    public List<CategoriesDto> getAllTodos(){
        return this.repositories.findAll()
                .stream()
                .map(CategoriesAdapter::toCategoryDto)
                .collect(Collectors.toList());
    }

    public CategoriesDto createCategory(CategoriesDto request){
        if (repositories.existsByType(request.getType())){
            throw new RuntimeException("Category with type '" + request.getType() + "' already exists.");
        }

        Categories category = CategoriesAdapter.toCategoryEntity(request);
        category = repositories.save(category);

        return CategoriesAdapter.toCategoryDto(category);
    }

    public CategoriesDto updateCategory(CategoriesDto request, Long id){
        Categories category = this.repositories.findById(id).orElseThrow(() -> new RuntimeException("No such category with ID: '" + id + "'"));
        if (request.getType() != null){
            category.setType(request.getType());
        }

        repositories.save(category);

        return CategoriesAdapter.toCategoryDto(category);
    }




}
