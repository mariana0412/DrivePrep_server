package com.phoenixsquad.driveprep_server.security.auth;

import com.phoenixsquad.driveprep_server.exceptions.UserNotFoundException;
import com.phoenixsquad.driveprep_server.security.auth.request.AuthenticationRequest;
import com.phoenixsquad.driveprep_server.security.auth.request.RegistrationRequest;
import com.phoenixsquad.driveprep_server.security.auth.response.AuthenticationResponse;
import com.phoenixsquad.driveprep_server.security.auth.response.RegistrationResponse;
import com.phoenixsquad.driveprep_server.security.config.JwtService;
import com.phoenixsquad.driveprep_server.security.user.User;
import com.phoenixsquad.driveprep_server.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public ResponseEntity<RegistrationResponse> register(RegistrationRequest request) {
        String email = request.getEmail();
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            System.out.println("User already exists.");
            return ResponseEntity.badRequest().build();
        }

        var user = User.builder()
                .id(request.getId())
                .surname(request.getSurname())
                .name(request.getName())
                .patronymic(request.getPatronymic())
                .categoryId(request.getCategoryId())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed.");
            return ResponseEntity.badRequest().build();
        }

        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        User user = userOptional.orElseThrow(() -> new UserNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(user);
        return ResponseEntity.ok(AuthenticationResponse.builder()
                .token(jwtToken)
                .build());
    }
}
