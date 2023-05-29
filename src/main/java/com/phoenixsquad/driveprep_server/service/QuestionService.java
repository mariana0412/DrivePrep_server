package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getQuestionsByTheme(Integer themeId);
    List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity);
    List<Question> getQuestionsByThemeAndDateAdded(Integer themeId, Date dateAdded);
}
