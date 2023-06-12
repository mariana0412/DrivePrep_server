package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Theme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Theme entities. Provides CRUD-operations and getting themes by Category ID
 */
@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {

    @Query("SELECT t FROM Theme t " +
            "WHERE t.categoryId = ?1 OR t.categoryId = 0 " +
            "ORDER BY t.id")
    List<Theme> getThemesByCategoryId(Integer categoryId);
}
