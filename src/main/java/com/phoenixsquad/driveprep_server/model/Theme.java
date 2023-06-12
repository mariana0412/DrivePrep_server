package com.phoenixsquad.driveprep_server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a theme of traffic rules, contains a lot of questions
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Theme")
public class Theme {
    @Id
    @Column(name = "theme_id")
    private Integer id;

    @Column(name = "theme_name")
    private String name;

    @Column(name = "theme_description")
    private String description;

    @Column(name = "category_id")
    private Integer categoryId;

}
