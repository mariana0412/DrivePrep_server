package com.phoenixsquad.driveprep_server.repository.info;

import com.phoenixsquad.driveprep_server.model.info.Law;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawRepository extends CrudRepository<Law, Long> {
    List<Law> getLawsByInfothemeId(Long infothemeId);
}
