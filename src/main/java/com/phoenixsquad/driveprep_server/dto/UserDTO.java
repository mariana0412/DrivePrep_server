package com.phoenixsquad.driveprep_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for representing user information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private Integer categoryId;
    private String email;
}
