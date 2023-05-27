package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion.SolvedQuestion;
import com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion.SolvedQuestionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedQuestionRepository extends CrudRepository<SolvedQuestion, SolvedQuestionId> {
}
