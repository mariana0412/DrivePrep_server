package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import com.phoenixsquad.driveprep_server.model.Question.Question;
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
            @RequestParam(required = false) Integer themeId,
            @RequestParam(required = false) Integer minComplexity,
            @RequestParam(required = false) Integer maxComplexity,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAdded
    ) {
        List<?> questions;
        if(userId != null)
            questions = getQuestionDTOs(themeId, minComplexity, maxComplexity, dateAdded, userId);
        else
            questions = getQuestions(themeId, minComplexity, maxComplexity, dateAdded);

        if (questions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    private List<QuestionDTO> getQuestionDTOs(Integer themeId, Integer minComplexity, Integer maxComplexity,
                                              Date dateAdded, String userId) {
        if (themeId != null && minComplexity != null && maxComplexity != null)
            return questionDTOService.getQuestionsByThemeAndComplexity(themeId, minComplexity, maxComplexity, userId);
        else if (themeId != null)
            return questionDTOService.getQuestionsByTheme(themeId, userId);
        else if(dateAdded != null)
            return questionDTOService.getQuestionsByDateAdded(dateAdded, userId);
        return questionDTOService.getAllQuestions(userId);
    }

    private List<Question> getQuestions(Integer themeId, Integer minComplexity, Integer maxComplexity, Date dateAdded) {
        if (themeId != null && minComplexity != null && maxComplexity != null)
            return questionService.getQuestionsByThemeAndComplexity(themeId, minComplexity, maxComplexity);
        else if (themeId != null)
            return questionService.getQuestionsByTheme(themeId);
        else if(dateAdded != null) {
            System.out.println("HEREEE");
            return questionService.getQuestionsByDateAdded(dateAdded);
        }
        System.out.println("tHEREEE");
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "/saved_questions")
    public ResponseEntity<List<QuestionDTO>> listSavedQuestions(String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getSavedQuestionsByUserId(userId);
        if(questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }

    @GetMapping(path = "/wrong_questions")
    public ResponseEntity<List<QuestionDTO>> listWrongQuestions(String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getIncorrectlySolvedQuestionsByUserId(userId);
        if(questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }

}
