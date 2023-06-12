package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.SavedQuestion;
import org.springframework.stereotype.Service;

/**
 * Service interface for managing Saved Questions.
 */
@Service
public interface SavedQuestionService {
    SavedQuestion findByUserIdAndQuestionId(String userId, Integer questionId);
    void saveQuestion(SavedQuestion savedQuestion);
    void deleteSavedQuestion(Integer questionId, String userId);
}
