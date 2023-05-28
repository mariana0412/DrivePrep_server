package com.phoenixsquad.driveprep_server.model;

import com.phoenixsquad.driveprep_server.model.composite.UserQuestionId;
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
    private UserQuestionId id;

}
