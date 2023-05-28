package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.exceptions.CategoryNotFoundException;
import com.phoenixsquad.driveprep_server.model.Category;
import com.phoenixsquad.driveprep_server.repository.CategoryRepository;
import com.phoenixsquad.driveprep_server.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return StreamSupport.stream(categories.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }
}
