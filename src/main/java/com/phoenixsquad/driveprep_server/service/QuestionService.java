package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getAllQuestionsFromTheme(Integer themeId);
}
