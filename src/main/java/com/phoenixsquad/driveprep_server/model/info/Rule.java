package com.phoenixsquad.driveprep_server.model.info;

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
@Table(name = "Rule")
public class Rule {

    @Id
    @Column(name = "rule_id", length = 20, nullable = false)
    String id;

    @Column(name = "rule_text", length = 800, nullable = false)
    String text;

    @Column(name = "rule_picture", length = 160)
    String picturePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_theme_id", nullable = false)
    private InfoTheme infoTheme;
}
