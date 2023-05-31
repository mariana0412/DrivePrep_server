package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface QuestionService {
    List<Question> getQuestions(Integer categoryId, Integer complexityLevel, Integer themeId, Date dateAdded);
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(Integer categoryId);
    List<Question> getQuestionsByCategoryAndComplexity(Integer categoryId, Integer complexityLevel);
    List<Question> getQuestionsByCategoryAndDateAdded(Integer categoryId, Date dateAdded);
    List<Question> getQuestionsByCategoryAndComplexityAndDateAdded(Integer categoryId, Integer complexityLevel,
                                                                   Date dateAdded);

    List<Question> getQuestionsByTheme(Integer themeId);
    List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer complexityLevel);
    List<Question> getQuestionsByThemeAndDateAdded(Integer themeId, Date dateAdded);
    List<Question> getQuestionsByThemeAndComplexityAndDateAdded(Integer themeId, Integer complexityLevel,
                                                                Date dateAdded);
}
