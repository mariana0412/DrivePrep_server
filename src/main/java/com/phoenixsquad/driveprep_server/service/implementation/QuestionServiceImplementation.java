package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImplementation(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        Iterable<Question> questions = questionRepository.findAll();
        return StreamSupport.stream(questions.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getAllQuestionsFromTheme(Integer themeId) {
        return questionRepository.getQuestionsFromTheme(themeId);
    }

}
