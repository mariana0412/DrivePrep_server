package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/questions")
    public ResponseEntity<List<Question>> listQuestions(@RequestParam(required = false) Integer themeId,
                                                        @RequestParam(required = false) Integer minComplexity,
                                                        @RequestParam(required = false) Integer maxComplexity) {
        if(themeId != null && minComplexity != null && maxComplexity != null) {
            return new ResponseEntity<>(questionService.getQuestionsByThemeAndComplexity(themeId, minComplexity,
                    maxComplexity), HttpStatus.OK);
        } else if(themeId != null)
            return new ResponseEntity<>(questionService.getQuestionsByTheme(themeId), HttpStatus.OK);

        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

}
