package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import com.phoenixsquad.driveprep_server.service.QuestionDTOService;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionDTOService questionDTOService;


    public QuestionController(QuestionService questionService, QuestionDTOService questionDTOService) {
        this.questionService = questionService;
        this.questionDTOService = questionDTOService;
    }

    @GetMapping(path = "/questions")
    public ResponseEntity<List<?>> listQuestions(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer complexityLevel,
            @RequestParam(required = false) Integer themeId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAdded,
            @RequestParam(required = false) String userId
    ) {
        List<?> questions = userId != null
                ? questionDTOService.getQuestions(categoryId, complexityLevel, themeId, dateAdded, userId)
                : questionService.getQuestions(categoryId, complexityLevel, themeId, dateAdded);

        if (questions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping(path = "/saved-questions")
    public ResponseEntity<List<QuestionDTO>> listSavedQuestions(String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getSavedQuestionsByUserId(userId);
        if(questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }

    @GetMapping(path = "/wrong-questions")
    public ResponseEntity<List<QuestionDTO>> listWrongQuestions(String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getIncorrectlySolvedQuestionsByUserId(userId);
        if(questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }

}
