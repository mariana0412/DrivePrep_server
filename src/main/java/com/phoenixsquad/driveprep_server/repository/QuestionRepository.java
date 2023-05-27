package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer>,
        PagingAndSortingRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.themeId = ?1")
    List<Question> getQuestionsFromTheme(Integer themeId);
}
