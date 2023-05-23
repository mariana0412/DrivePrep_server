package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/questions")
    public ResponseEntity<Page<Question>> listQuestions(final Pageable pageable) {
        return new ResponseEntity<>(questionService.getQuestions(pageable), HttpStatus.OK);
    }

}
