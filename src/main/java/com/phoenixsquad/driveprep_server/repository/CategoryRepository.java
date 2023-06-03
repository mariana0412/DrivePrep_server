package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.id != 0")
    List<Category> getAllCategories();
}
