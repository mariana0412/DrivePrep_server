package com.phoenixsquad.driveprep_server.security.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO getUserById(String id);
    void saveUser(UserDTO user);
    void deleteUser(String id);
}
