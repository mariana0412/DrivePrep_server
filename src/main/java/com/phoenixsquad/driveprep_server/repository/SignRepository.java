package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Sign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Sign entities. Provides CRUD-operations and getting signs by Infotheme ID
 */
@Repository
public interface SignRepository extends CrudRepository<Sign, String> {
    List<Sign> getSignsByInfothemeId(Long infothemeId);
}
