package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.dto.QuestionDTO;
import com.phoenixsquad.driveprep_server.model.Question;
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

/**
 * Controller class for handling question-related requests.
 */
@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionDTOService questionDTOService;

    public QuestionController(QuestionService questionService, QuestionDTOService questionDTOService) {
        this.questionService = questionService;
        this.questionDTOService = questionDTOService;
    }

    /**
     * Retrieves a list of questions based on the provided filters.
     *
     * @param categoryId       The ID of the category to filter by.
     * @param complexityLevel  The complexity level to filter by.
     * @param themeId          The ID of the theme to filter by.
     * @param dateAdded        The date added to filter by.
     * @param userId           The ID of the user (optional) to filter by.
     * @return ResponseEntity containing the list of questions or NO_CONTENT status if no questions are found.
     */
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

    /**
     * Retrieves a list of exam questions based on the provided category and complexity level.
     *
     * @param categoryId      The ID of the category.
     * @param complexityLevel The complexity level (optional) to filter by.
     * @return ResponseEntity containing the list of exam questions or NO_CONTENT status if no questions are found.
     */
    @GetMapping(path = "/exam-questions")
    public ResponseEntity<List<Question>> listExamQuestions(
            @RequestParam Integer categoryId,
            @RequestParam(required = false) Integer complexityLevel
    ) {
        List<Question> examQuestions;
        if (complexityLevel != null)
            examQuestions = questionService.getExamQuestionsByCategoryAndComplexity(categoryId, complexityLevel);
        else
            examQuestions = questionService.getExamQuestionsByCategory(categoryId);

        if (examQuestions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(examQuestions, HttpStatus.OK);
    }

    /**
     * Retrieves a list of saved questions for the specified user.
     *
     * @param userId The ID of the user.
     * @return ResponseEntity containing the list of saved questions or NO_CONTENT status if no questions are found.
     */
    @GetMapping(path = "/saved-questions")
    public ResponseEntity<List<QuestionDTO>> listSavedQuestions(@RequestParam String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getSavedQuestionsByUserId(userId);
        if (questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }

    /**
     * Retrieves a list of incorrectly solved questions for the specified user.
     *
     * @param userId The ID of the user.
     * @return ResponseEntity containing the list of incorrectly solved questions or NO_CONTENT status if no questions are found.
     */
    @GetMapping(path = "/wrong-questions")
    public ResponseEntity<List<QuestionDTO>> listWrongQuestions(@RequestParam String userId) {
        List<QuestionDTO> questionDTOs = questionDTOService.getIncorrectlySolvedQuestionsByUserId(userId);
        if (questionDTOs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
    }
}
