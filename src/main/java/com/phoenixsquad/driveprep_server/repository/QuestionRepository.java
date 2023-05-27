package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Question.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.themeId = ?1")
    List<Question> getQuestionsByTheme(Integer themeId);

    @Query("SELECT q FROM Question q WHERE q.themeId = ?1 AND q.complexity BETWEEN ?2 AND ?3")
    List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity);

    @Query("SELECT q FROM Question q " +
            "INNER JOIN SavedQuestion sq ON q.id = sq.id.questionId " +
            "WHERE sq.id.userId = ?1")
    List<Question> getSavedQuestionsByUserId(String userId);

    @Query("SELECT q FROM Question q " +
            "INNER JOIN SolvedQuestion sq ON q.id = sq.id.questionId " +
            "WHERE sq.id.userId = ?1 AND sq.correct = false")
    List<Question> getIncorrectlySolvedQuestionsByUserId(String userId);
}
