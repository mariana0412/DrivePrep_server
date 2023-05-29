package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.model.SolvedQuestion;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionDTOService;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import com.phoenixsquad.driveprep_server.service.SolvedQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionDTOServiceImpl implements QuestionDTOService {

    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final SolvedQuestionService solvedQuestionService;
    private final SavedQuestionService savedQuestionService;

    public QuestionDTOServiceImpl(QuestionRepository questionRepository, QuestionService questionService,
                                  SolvedQuestionService solvedQuestionService, SavedQuestionService savedQuestionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
        this.solvedQuestionService = solvedQuestionService;
        this.savedQuestionService = savedQuestionService;
    }

    @Override
    public List<QuestionDTO> getAllQuestions(String userId) {
        List<Question> questions = questionService.getAllQuestions();
        return mapQuestionsToDTO(questions, userId);
    }

    @Override
    public List<QuestionDTO> getQuestionsByTheme(Integer themeId, String userId) {
        List<Question> questions = questionService.getQuestionsByTheme(themeId);
        return mapQuestionsToDTO(questions, userId);
    }

    @Override
    public List<QuestionDTO> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity, String userId) {
        List<Question> questions = questionService.getQuestionsByThemeAndComplexity(themeId, minComplexity, maxComplexity);
        return mapQuestionsToDTO(questions, userId);
    }

    @Override
    public List<QuestionDTO> getSavedQuestionsByUserId(String userId) {
        List<Question> questions = questionRepository.getSavedQuestionsByUserId(userId);
        return mapQuestionsToDTO(questions, userId);
    }

    @Override
    public List<QuestionDTO> getIncorrectlySolvedQuestionsByUserId(String userId) {
        List<Question> questions = questionRepository.getIncorrectlySolvedQuestionsByUserId(userId);
        return mapQuestionsToDTO(questions, userId);
    }

    @Override
    public List<QuestionDTO> getQuestionsByThemeAndDateAdded(Integer themeId, Date dateAdded, String userId) {
        List<Question> questions = questionService.getQuestionsByThemeAndDateAdded(themeId, dateAdded);
        return mapQuestionsToDTO(questions, userId);
    }

    private List<QuestionDTO> mapQuestionsToDTO(List<Question> questions, String userId) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setThemeId(question.getThemeId());
            questionDTO.setText(question.getText());
            questionDTO.setTips(question.getTips());
            questionDTO.setAdditionYear(question.getDateAdded());
            questionDTO.setPicturePath(question.getPicturePath());
            questionDTO.setAnswer(question.getAnswer());
            questionDTO.setVar1(question.getVar1());
            questionDTO.setVar2(question.getVar2());
            questionDTO.setVar3(question.getVar3());
            questionDTO.setComplexity(question.getComplexity());

            SolvedQuestion solvedQuestion = solvedQuestionService.findByUserIdAndQuestionId(userId, question.getId());
            if(solvedQuestion != null)
                questionDTO.setSolved(solvedQuestion.isCorrect());

            boolean saved = savedQuestionService.findByUserIdAndQuestionId(userId, question.getId()) != null;
            questionDTO.setSaved(saved);

            questionDTOs.add(questionDTO);
        }
        return questionDTOs;
    }
}
