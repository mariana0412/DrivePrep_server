package com.phoenixsquad.driveprep_server.model;

import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Solved_Question")
public class SolvedQuestion {

    @EmbeddedId
    private UserQuestionId id;
    private boolean correct;
}
