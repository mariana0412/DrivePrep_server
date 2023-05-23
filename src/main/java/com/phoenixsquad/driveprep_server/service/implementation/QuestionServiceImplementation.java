package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImplementation(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Page<Question> getQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Optional<Question> getQuestionById(Integer id) {
        return Optional.empty(); // TODO: implement getting question by ID
    }
}
