package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.exceptions.CategoryNotFoundException;
import com.phoenixsquad.driveprep_server.model.Category;
import com.phoenixsquad.driveprep_server.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling category-related requests.
 */
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Retrieves all categories.
     *
     * @return ResponseEntity containing the list of categories or NO_CONTENT status if no categories are found.
     */
    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category.
     * @return ResponseEntity containing the category if found, or NOT_FOUND status if the category is not found.
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
