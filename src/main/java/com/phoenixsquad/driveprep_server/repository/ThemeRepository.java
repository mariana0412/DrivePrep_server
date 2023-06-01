package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {

    List<Theme> getThemesByCategoryId(Integer categoryId);
}
