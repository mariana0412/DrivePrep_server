package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.SolvedQuestion;
import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedQuestionRepository extends CrudRepository<SolvedQuestion, UserQuestionId> {
}
