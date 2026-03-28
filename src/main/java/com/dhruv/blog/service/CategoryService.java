package com.dhruv.blog.service;

import com.dhruv.blog.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();

    Category createCategory(Category category);

    void deleteCategory(Long id);
}
