package com.dhruv.blog.service.impl;

import com.dhruv.blog.domain.entity.Category;
import com.dhruv.blog.repository.CategoryRepository;
import com.dhruv.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
