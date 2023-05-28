package com.phoenixsquad.driveprep_server.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
