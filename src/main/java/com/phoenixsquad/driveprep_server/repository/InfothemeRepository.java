package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Infotheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Infotheme entities. Provides CRUD-operations and getting Infothemes about Signs
 */
@Repository
public interface InfothemeRepository extends CrudRepository<Infotheme, Long> {
    
    @Query("SELECT t FROM Infotheme t INNER JOIN Sign s ON t.id = s.infotheme.id")
    List<Infotheme> getSignInfoThemes();
}
