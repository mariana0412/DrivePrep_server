package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service interface for managing QuestionDTOs.
 */
@Service
public interface QuestionDTOService {

    List<QuestionDTO> getSavedQuestionsByUserId(String userId);
    List<QuestionDTO> getIncorrectlySolvedQuestionsByUserId(String userId);
    List<QuestionDTO> getQuestions(Integer categoryId, Integer complexityLevel, Integer themeId, Date dateAdded,
                                   String userId);
}
