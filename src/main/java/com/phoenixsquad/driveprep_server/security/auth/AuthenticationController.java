package com.phoenixsquad.driveprep_server.security.auth;

import com.phoenixsquad.driveprep_server.security.auth.request.AuthenticationRequest;
import com.phoenixsquad.driveprep_server.security.auth.request.RegistrationRequest;
import com.phoenixsquad.driveprep_server.security.auth.response.AuthenticationResponse;
import com.phoenixsquad.driveprep_server.security.auth.response.RegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling authentication and registration requests.
 */
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        return service.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }

}
