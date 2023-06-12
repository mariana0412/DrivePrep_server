package com.phoenixsquad.driveprep_server.model.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Represents an ID which contains both question ID and user ID
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserQuestionId implements Serializable {
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "user_id")
    private String userId;
}
