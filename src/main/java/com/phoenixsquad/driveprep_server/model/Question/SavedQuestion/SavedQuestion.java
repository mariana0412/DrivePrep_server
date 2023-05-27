package com.phoenixsquad.driveprep_server.model.Question.SavedQuestion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Saved_Question")
public class SavedQuestion {

    @EmbeddedId
    private SavedQuestionId id;

}
