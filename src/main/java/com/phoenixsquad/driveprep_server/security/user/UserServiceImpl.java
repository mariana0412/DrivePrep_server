package com.phoenixsquad.driveprep_server.security.user;

import com.phoenixsquad.driveprep_server.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User not found");
        return mapUserToDTO(userOptional.get());
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
}
