package com.phoenixsquad.driveprep_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a road sign
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Sign")
public class Sign {

    @Id
    @Column(name = "sign_id", length = 20, nullable = false)
    private String id;

    @Column(name = "sign_name", length = 260, nullable = false)
    private String name;

    @Column(name = "sign_text", length = 800, nullable = false)
    private String text;

    @Column(name = "sign_picture", length = 160, nullable = false)
    private String picturePath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "info_theme_id", nullable = false)
    private Infotheme infotheme;
}