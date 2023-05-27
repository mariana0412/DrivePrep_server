package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question.SavedQuestion.SavedQuestion;
import org.springframework.stereotype.Service;

@Service
public interface SavedQuestionService {
    SavedQuestion findByUserIdAndQuestionId(String userId, Integer questionId);
}
