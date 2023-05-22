package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface QuestionService {
    Page<Question> getQuestions(Pageable pageable);

    Optional<Question> getQuestionById(Integer id);
}
