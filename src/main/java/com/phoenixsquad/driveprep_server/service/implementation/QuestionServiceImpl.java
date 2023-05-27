package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import com.phoenixsquad.driveprep_server.model.Question.Question;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import com.phoenixsquad.driveprep_server.service.SolvedQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SolvedQuestionService solvedQuestionService;
    private final SavedQuestionService savedQuestionService;

    public QuestionServiceImpl(QuestionRepository questionRepository,
                               SolvedQuestionService solvedQuestionService,
                               SavedQuestionService savedQuestionService) {
        this.questionRepository = questionRepository;
        this.solvedQuestionService = solvedQuestionService;
        this.savedQuestionService = savedQuestionService;
    }

    @Override
    public List<Question> getAllQuestions() {
        Iterable<Question> questions = questionRepository.findAll();
        return StreamSupport.stream(questions.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getQuestionsByTheme(Integer themeId) {
        return questionRepository.getQuestionsByTheme(themeId);
    }

    @Override
    public List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer minComplexity, Integer maxComplexity) {
        return questionRepository.getQuestionsByThemeAndComplexity(themeId, minComplexity, maxComplexity);
    }

    @Override
    public List<Question> getSavedQuestionsByUserId(String userId) {
        return questionRepository.getSavedQuestionsByUserId(userId);
    }

    @Override
    public List<QuestionDTO> getIncorrectlySolvedQuestionsByUserId(String userId) {
        List<Question> questions = questionRepository.getIncorrectlySolvedQuestionsByUserId(userId);
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
            questionDTO.setAdditionYear(question.getAdditionYear());
            questionDTO.setPicturePath(question.getPicturePath());
            questionDTO.setAnswer(question.getAnswer());
            questionDTO.setVar1(question.getVar1());
            questionDTO.setVar2(question.getVar2());
            questionDTO.setVar3(question.getVar3());
            questionDTO.setComplexity(question.getComplexity());

            boolean solved = solvedQuestionService.findByUserIdAndQuestionId(userId, question.getId()).isCorrect();
            questionDTO.setSolved(solved);

            boolean saved = savedQuestionService.findByUserIdAndQuestionId(userId, question.getId()) != null;
            questionDTO.setSaved(saved);

            questionDTOs.add(questionDTO);
        }
        return questionDTOs;
    }
}