package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
