package com.phoenixsquad.driveprep_server.repository.info;

import com.phoenixsquad.driveprep_server.model.info.Sign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignRepository extends CrudRepository<Sign, String> {
    List<Sign> getSignsByInfothemeId(Long infothemeId);
}
