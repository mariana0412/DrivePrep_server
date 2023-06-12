package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.SolvedQuestion;
import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
import com.phoenixsquad.driveprep_server.repository.SolvedQuestionRepository;
import com.phoenixsquad.driveprep_server.service.SolvedQuestionService;
import org.springframework.stereotype.Service;

/**
 * Implementation of the SolvedQuestionService interface.
 */
@Service
public class SolvedQuestionServiceImpl implements SolvedQuestionService {

    private final SolvedQuestionRepository solvedQuestionRepository;

    public SolvedQuestionServiceImpl(SolvedQuestionRepository solvedQuestionRepository) {
        this.solvedQuestionRepository = solvedQuestionRepository;
    }

    @Override
    public SolvedQuestion findByUserIdAndQuestionId(String userId, Integer questionId) {
        UserQuestionId id = new UserQuestionId(questionId, userId);
        return solvedQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSolvedQuestion(SolvedQuestion solvedQuestion) {
        solvedQuestionRepository.save(solvedQuestion);
    }

}
