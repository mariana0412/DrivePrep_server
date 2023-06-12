package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.SavedQuestion;
import com.phoenixsquad.driveprep_server.service.SavedQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling saved question-related requests.
 */
@RestController
public class SavedQuestionController {

    private final SavedQuestionService savedQuestionService;

    public SavedQuestionController(SavedQuestionService savedQuestionService) {
        this.savedQuestionService = savedQuestionService;
    }

    /**
     * Saves a question for a user.
     *
     * @param savedQuestion The saved question to be saved.
     * @return ResponseEntity with a success message if the question is saved successfully, or a bad request message if an error occurs.
     */
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

    /**
     * Deletes a saved question for a user.
     *
     * @param questionId The ID of the saved question to be deleted.
     * @param userId     The ID of the user.
     * @return ResponseEntity with a success message if the saved question is deleted successfully, or a bad request message if an error occurs.
     */
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
