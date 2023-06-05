package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByCategory(Integer categoryId);

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "AND q.complexity BETWEEN ?2 AND ?3 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByCategoryAndComplexity(Integer categoryId, Integer minComplexity, Integer maxComplexity);

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "AND q.dateAdded >= ?2 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByCategoryAndDateAdded(Integer categoryId, Date dateAdded);

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "AND q.complexity BETWEEN ?2 AND ?3 " +
            "AND q.dateAdded >= ?4 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByCategoryAndComplexityAndDateAdded(Integer categoryId, Integer minComplexity,
                                                                   Integer maxComplexity, Date dateAdded);

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "ORDER BY RANDOM() " +
            "LIMIT 20")
    List<Question> getExamQuestionsByCategory(Integer categoryId);

    @Query("SELECT q FROM Question q " +
            "JOIN Theme t ON q.themeId = t.id " +
            "JOIN Category c ON t.categoryId = c.id " +
            "WHERE c.id = ?1 OR c.id = 0 " +
            "AND q.complexity BETWEEN ?2 AND ?3 " +
            "ORDER BY RANDOM() " +
            "LIMIT 20")
    List<Question> getExamQuestionsByCategoryAndComplexity(Integer categoryId, Integer minComplexity,
                                                           Integer maxComplexity);

    @Query("SELECT q FROM Question q " +
            "WHERE q.themeId = ?1 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByTheme(Integer themeId);

    @Query("SELECT q FROM Question q " +
            "WHERE q.themeId = ?1 " +
            "AND q.complexity BETWEEN ?2 AND ?3 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity);

    @Query("SELECT q FROM Question q " +
            "WHERE q.themeId = ?1 " +
            "AND q.dateAdded >= ?2 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByThemeAndDateAdded(Integer themeId, Date dateAdded);

    @Query("SELECT q FROM Question q " +
            "WHERE q.themeId = ?1 " +
            "AND q.complexity BETWEEN ?2 AND ?3 " +
            "AND q.dateAdded >= ?4 " +
            "ORDER BY RANDOM()")
    List<Question> getQuestionsByThemeAndComplexityAndDateAdded(Integer themeId, Integer minComplexity,
                                                                Integer maxComplexity, Date dateAdded);

    @Query("SELECT q FROM Question q " +
            "INNER JOIN SavedQuestion sq ON q.id = sq.id.questionId " +
            "WHERE sq.id.userId = ?1 " +
            "ORDER BY RANDOM()")
    List<Question> getSavedQuestionsByUserId(String userId);

    @Query("SELECT q FROM Question q " +
            "INNER JOIN SolvedQuestion sq ON q.id = sq.id.questionId " +
            "WHERE sq.id.userId = ?1 AND sq.correct = false " +
            "ORDER BY RANDOM()")
    List<Question> getIncorrectlySolvedQuestionsByUserId(String userId);
}
