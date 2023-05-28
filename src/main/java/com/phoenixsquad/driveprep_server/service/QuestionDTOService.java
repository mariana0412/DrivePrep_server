package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionDTOService {
    List<QuestionDTO> getAllQuestions(String userId);
    List<QuestionDTO> getQuestionsByTheme(Integer themeId, String userId);
    List<QuestionDTO> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity,
                                                       String userId);
    List<QuestionDTO> getSavedQuestionsByUserId(String userId);
    List<QuestionDTO> getIncorrectlySolvedQuestionsByUserId(String userId);
}
