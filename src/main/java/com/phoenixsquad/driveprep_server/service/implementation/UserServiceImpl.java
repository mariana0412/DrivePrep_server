package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.dto.UserDTO;
import com.phoenixsquad.driveprep_server.exceptions.EmailInUseException;
import com.phoenixsquad.driveprep_server.exceptions.InvalidOldPasswordException;
import com.phoenixsquad.driveprep_server.exceptions.UserNotFoundException;
import com.phoenixsquad.driveprep_server.exceptions.WrongPasswordFormat;
import com.phoenixsquad.driveprep_server.model.User;
import com.phoenixsquad.driveprep_server.repository.UserRepository;
import com.phoenixsquad.driveprep_server.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the UserService interface.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO getUserDTOById(String id) {
        User user = getUserById(id);
        return mapUserToDTO(user);
    }

    private User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private UserDTO mapUserToDTO(User user) {
        return new UserDTO(user.getId(), user.getSurname(), user.getName(), user.getPatronymic(), user.getCategoryId(),
                user.getEmail());
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        String userId = userDTO.getId();
        String userEmail = userDTO.getEmail();

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User not found");

        checkEmailUniqueness(userEmail, userId);

        User user = userOptional.get();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPatronymic(userDTO.getPatronymic());
        user.setCategoryId(userDTO.getCategoryId());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
    }

    private void checkEmailUniqueness(String userEmail, String userId) {
        Optional<User> userOptional = userRepository.findByEmail(userEmail);
        if(userOptional.isPresent()) {
            String emailOwnerId = userOptional.get().getId();
            if (!emailOwnerId.equals(userId))
                throw new EmailInUseException("This email is already in use");
        }
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void changePassword(String id, String oldPassword, String newPassword) {
        User user = getUserById(id);
        checkOldPassword(oldPassword, user.getPassword());
        checkNewPasswordFormat(newPassword);
        setNewPassword(user, newPassword);
    }

    private void checkOldPassword(String oldPassword, String passwordInDb) {
        if (!passwordEncoder.matches(oldPassword, passwordInDb))
            throw new InvalidOldPasswordException("Invalid old password");
    }

    private void checkNewPasswordFormat(String password) {
        if(password.length() < 8)
            throw new WrongPasswordFormat("Password length is less than 8 symbols.");
    }

    private void setNewPassword(User user, String newPassword) {
        String encryptedNewPassword = encryptPassword(newPassword);
        user.setPassword(encryptedNewPassword);
        userRepository.save(user);
    }

    private String encryptPassword(String newPassword) {
        return passwordEncoder.encode(newPassword);
    }
}
