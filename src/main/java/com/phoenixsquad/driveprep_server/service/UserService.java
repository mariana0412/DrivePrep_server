package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO getUserDTOById(String id);
    void saveUser(UserDTO user);
    void deleteUser(String id);
    void changePassword(String id, String oldPassword, String newPassword);
}
