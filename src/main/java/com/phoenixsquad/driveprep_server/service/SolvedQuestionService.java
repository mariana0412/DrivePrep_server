package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion.SolvedQuestion;
import org.springframework.stereotype.Service;

@Service
public interface SolvedQuestionService {
    SolvedQuestion findByUserIdAndQuestionId(String userId, Integer questionId);
}
