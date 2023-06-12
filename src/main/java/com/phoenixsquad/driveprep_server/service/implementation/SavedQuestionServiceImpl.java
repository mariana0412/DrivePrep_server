package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.SavedQuestion;
import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
import com.phoenixsquad.driveprep_server.repository.SavedQuestionRepository;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import org.springframework.stereotype.Service;

/**
 * Implementation of the SavedQuestionService interface.
 */
@Service
public class SavedQuestionServiceImpl implements SavedQuestionService {
    private final SavedQuestionRepository savedQuestionRepository;

    public SavedQuestionServiceImpl(SavedQuestionRepository savedQuestionRepository) {
        this.savedQuestionRepository = savedQuestionRepository;
    }

    @Override
    public SavedQuestion findByUserIdAndQuestionId(String userId, Integer questionId) {
        UserQuestionId id = new UserQuestionId(questionId, userId);
        return savedQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveQuestion(SavedQuestion savedQuestion) {
        savedQuestionRepository.save(savedQuestion);
    }

    @Override
    public void deleteSavedQuestion(Integer questionId, String userId) {
        UserQuestionId savedQuestionId = new UserQuestionId(questionId, userId);
        savedQuestionRepository.deleteById(savedQuestionId);
    }
}
