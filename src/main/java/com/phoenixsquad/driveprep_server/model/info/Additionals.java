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
@Table(name = "Additionals")
public class Additionals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id", nullable = false)
    private Long id;

    @Column(name = "add_text", length = 1300)
    private String text;

    @Column(name = "add_url_text", length = 260)
    private String textUrl;

    @Column(name = "add_url_general")
    private String generalUrl;

    @Column(name = "add_url_picture")
    private String pictureUrl;

    @Column(name = "add_url_video")
    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_theme_id")
    private InfoTheme infoTheme;
}