package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.SavedQuestion;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavedQuestionController {

    private final SavedQuestionService savedQuestionService;

    public SavedQuestionController(SavedQuestionService savedQuestionService) {
        this.savedQuestionService = savedQuestionService;
    }

    @PostMapping("/saved-questions")
    public ResponseEntity<String> saveQuestion(@RequestBody SavedQuestion savedQuestion) {
        try {
            savedQuestionService.saveQuestion(savedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to save question");
        }
        return ResponseEntity.ok("Question saved successfully");
    }

    @DeleteMapping("/saved-questions/{questionId}/{userId}")
    public ResponseEntity<String> deleteSavedQuestion(
            @PathVariable Integer questionId,
            @PathVariable String userId
    ) {
        try {
            savedQuestionService.deleteSavedQuestion(questionId, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to delete saved question");
        }
        return ResponseEntity.ok("Saved question deleted successfully");
    }
}
