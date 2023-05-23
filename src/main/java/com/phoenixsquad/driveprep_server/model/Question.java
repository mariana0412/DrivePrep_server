package com.phoenixsquad.driveprep_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @Column(name = "question_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @Column(name = "text")
    private String text;

    @Column(name = "tips")
    private String tips;

    @Column(name = "year")
    private Date additionYear; // TODO: find out what type is the most appropriate for Year

    @Column(name = "picture")
    private String picturePath;

    @Column(name = "answer")
    private String answer;

    @Column(name = "var1")
    private String var1;

    @Column(name = "var2")
    private String var2;

    @Column(name = "var3")
    private String var3;
}