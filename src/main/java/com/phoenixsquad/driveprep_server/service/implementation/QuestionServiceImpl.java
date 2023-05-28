package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
    public List<Question> getQuestionsByDateAdded(Date dateAdded) {
        return questionRepository.getQuestionsByDateAdded(dateAdded);
    }
}