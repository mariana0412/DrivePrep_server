package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.SolvedQuestion;
import com.phoenixsquad.driveprep_server.service.SolvedQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolvedQuestionController {

    private final SolvedQuestionService solvedQuestionService;

    public SolvedQuestionController(SolvedQuestionService solvedQuestionService) {
        this.solvedQuestionService = solvedQuestionService;
    }

    /**
     * Saves a solved question.
     *
     * @param solvedQuestion The solved question to be saved.
     * @return ResponseEntity with a success message if the solved question is saved successfully, or a bad request
     *         with an error message if the save operation fails.
     */
    @PostMapping("/solved-questions")
    public ResponseEntity<String> saveSolvedQuestion(@RequestBody SolvedQuestion solvedQuestion) {
        try {
            solvedQuestionService.saveSolvedQuestion(solvedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to save solved question");
        }
        return ResponseEntity.ok("Solved question saved successfully");
    }

    /**
     * Updates a solved question.
     *
     * @param solvedQuestion The solved question to be updated.
     * @return ResponseEntity with a success message if the solved question is updated successfully, or a bad request
     *         with an error message if the update operation fails.
     */
    @PutMapping("/solved-questions")
    public ResponseEntity<String> updateSolvedQuestion(@RequestBody SolvedQuestion solvedQuestion) {
        try {
            solvedQuestionService.saveSolvedQuestion(solvedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to update solved question");
        }
        return ResponseEntity.ok("Solved question updated successfully");
    }
}
