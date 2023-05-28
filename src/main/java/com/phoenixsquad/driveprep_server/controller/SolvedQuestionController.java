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

    @PutMapping("/solved-questions")
    public ResponseEntity<String> updateSolvedQuestion(@RequestBody SolvedQuestion solvedQuestion) {
        try {
            solvedQuestionService.saveSolvedQuestion(solvedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to update solved question");
        }
        return ResponseEntity.ok("Solved question update successfully");
    }
}
