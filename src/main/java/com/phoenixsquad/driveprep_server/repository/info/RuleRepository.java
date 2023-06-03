package com.phoenixsquad.driveprep_server.repository.info;

import com.phoenixsquad.driveprep_server.model.info.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends CrudRepository<Rule, String> {
    List<Rule> getRulesByInfothemeId(Long infothemeId);
}