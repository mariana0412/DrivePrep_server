package com.phoenixsquad.driveprep_server.model.Question.SolvedQuestion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SolvedQuestionId implements Serializable {
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "user_id")
    private String userId;
    // TODO: make one ID for solved and saved or even parent for them (too much similarities)
}
