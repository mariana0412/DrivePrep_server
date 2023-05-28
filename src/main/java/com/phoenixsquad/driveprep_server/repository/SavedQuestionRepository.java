package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.SavedQuestion;
import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedQuestionRepository extends CrudRepository<SavedQuestion, UserQuestionId> {
}
