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
@Table(name = "Info_theme")
public class InfoTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_theme_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_theme_id", nullable = false)
    private InfoTheme parentInfoTheme;

    @Column(name = "info_theme_name", length = 70, nullable = false)
    private String name;
}