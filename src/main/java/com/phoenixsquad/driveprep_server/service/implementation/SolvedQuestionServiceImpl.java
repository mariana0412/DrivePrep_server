package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion.SolvedQuestion;
import com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion.SolvedQuestionId;
import com.phoenixsquad.driveprep_server.repository.SolvedQuestionRepository;
import com.phoenixsquad.driveprep_server.service.SolvedQuestionService;
import org.springframework.stereotype.Service;

@Service
public class SolvedQuestionServiceImpl implements SolvedQuestionService {

    private final SolvedQuestionRepository solvedQuestionRepository;

    public SolvedQuestionServiceImpl(SolvedQuestionRepository solvedQuestionRepository) {
        this.solvedQuestionRepository = solvedQuestionRepository;
    }

    @Override
    public SolvedQuestion findByUserIdAndQuestionId(String userId, Integer questionId) {
        SolvedQuestionId id = new SolvedQuestionId(questionId, userId);
        return solvedQuestionRepository.findById(id).orElse(null);
    }
}
