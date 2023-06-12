package com.phoenixsquad.driveprep_server.security.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a registration request.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String surname;          // The surname of the user for registration.
    private String name;             // The name of the user for registration.
    private String patronymic;       // The patronymic of the user for registration.
    private Integer categoryId;      // The ID of the category associated with the user.
    private String email;            // The email of the user for registration.
    private String password;         // The password of the user for registration.
}
