package com.fajlay.Todo.adapters;

import com.fajlay.Todo.dtos.CategoriesDto;
import com.fajlay.Todo.entities.Categories;

public class CategoriesAdapter {
    public static Categories toCategoryEntity(CategoriesDto categories){
        Categories category = new Categories();
        category.setType(categories.getType());

        return category;
    }

    public static CategoriesDto toCategoryDto(Categories categories){
        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setId(categories.getId());
        categoriesDto.setType(categories.getType());

        return categoriesDto;
    }

    public static Categories updateCategoryEntity(CategoriesDto request, Categories categories){
        if (request.getType() != null){
            categories.setType(request.getType());
        }

        return categories;
    }

}
