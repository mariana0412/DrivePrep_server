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
@Table(name = "Law")
public class Law {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "law_id", nullable = false)
    private Long id;

    @Column(name = "law_name", length = 360, nullable = false)
    private String name;

    @Column(name = "law_text", length = 1300)
    private String text;

    @Column(name = "law_url", length = 160, nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_theme_id", nullable = false)
    private Infotheme infotheme;
}

