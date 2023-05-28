package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer id);
}
