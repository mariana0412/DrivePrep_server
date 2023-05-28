package com.phoenixsquad.driveprep_server.security.user;

import com.phoenixsquad.driveprep_server.exceptions.InvalidPasswordException;
import com.phoenixsquad.driveprep_server.exceptions.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> userOptional = userRepository.findById(userDTO.getId());
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User not found");

        User user = userOptional.get();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPatronymic(userDTO.getPatronymic());
        user.setCategoryId(userDTO.getCategoryId());
        user.setEmail(userDTO.getEmail());

        System.out.println(user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void changePassword(String id, String oldPassword, String newPassword) {
        User user = getUserById(id);
        checkOldPassword(oldPassword, user.getPassword());
        setNewPassword(user, newPassword);
    }

    private void checkOldPassword(String oldPassword, String passwordInDb) {
        if (!passwordEncoder.matches(oldPassword, passwordInDb))
            throw new InvalidPasswordException("Invalid old password");
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
