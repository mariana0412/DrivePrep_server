package com.phoenixsquad.driveprep_server.security.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private Integer categoryId;
    private String email;
    String password;
}
