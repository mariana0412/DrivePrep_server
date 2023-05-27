package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question.SavedQuestion.SavedQuestion;
import com.phoenixsquad.driveprep_server.model.Question.SavedQuestion.SavedQuestionId;
import com.phoenixsquad.driveprep_server.repository.SavedQuestionRepository;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import org.springframework.stereotype.Service;

@Service
public class SavedQuestionServiceImpl implements SavedQuestionService {
    private final SavedQuestionRepository savedQuestionRepository;

    public SavedQuestionServiceImpl(SavedQuestionRepository savedQuestionRepository) {
        this.savedQuestionRepository = savedQuestionRepository;
    }

    @Override
    public SavedQuestion findByUserIdAndQuestionId(String userId, Integer questionId) {
        SavedQuestionId id = new SavedQuestionId(questionId, userId);
        return savedQuestionRepository.findById(id).orElse(null);
    }
}
