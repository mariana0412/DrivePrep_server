package com.phoenixsquad.driveprep_server.model.Question.SavedQuestion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SavedQuestionId implements Serializable {
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "user_id")
    private String userId;
}
