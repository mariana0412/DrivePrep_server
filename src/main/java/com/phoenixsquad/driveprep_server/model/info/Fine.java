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
@Table(name = "Fine")
public class Fine {

    @Id
    @Column(name = "fine_id", nullable = false)
    private String id;

    @Column(name = "fine_text", length = 1250, nullable = false)
    private String text;

    @Column(name = "fine_sum", nullable = false)
    private Integer sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_theme_id", nullable = false)
    private InfoTheme infoTheme;
}