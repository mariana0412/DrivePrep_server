package com.phoenixsquad.driveprep_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDTO {
    private Integer id;
    private Integer themeId;
    private String text;
    private String tips;
    private Date additionYear;
    private String picturePath;
    private String answer;
    private String var1;
    private String var2;
    private String var3;
    private Integer complexity;
    private Boolean solved;
    private Boolean saved;
}
