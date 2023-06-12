package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.SolvedQuestion;
import org.springframework.stereotype.Service;

/**
 * Service interface for managing Solved Questions.
 */
@Service
public interface SolvedQuestionService {
    SolvedQuestion findByUserIdAndQuestionId(String userId, Integer questionId);
    void saveSolvedQuestion(SolvedQuestion solvedQuestion);
}
