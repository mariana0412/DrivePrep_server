package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.exceptions.EmailInUseException;
import com.phoenixsquad.driveprep_server.exceptions.InvalidOldPasswordException;
import com.phoenixsquad.driveprep_server.exceptions.UserNotFoundException;
import com.phoenixsquad.driveprep_server.dto.ChangePasswordDTO;
import com.phoenixsquad.driveprep_server.dto.UserDTO;
import com.phoenixsquad.driveprep_server.exceptions.WrongPasswordFormat;
import com.phoenixsquad.driveprep_server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves the user data for the specified user ID.
     *
     * @param id The ID of the user.
     * @return ResponseEntity containing the user data if found, or NOT_FOUND if the user is not found.
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserDataById(@PathVariable("id") String id) {
        try {
            UserDTO user = userService.getUserDTOById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates the user data for the specified user ID.
     *
     * @param user The updated user data.
     * @return ResponseEntity with a success message if the user data is updated successfully,
     *         or a bad request with an error message if there are validation or server errors.
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUserData(@RequestBody UserDTO user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("Інформація про користувача змінена успішно.");
        } catch (EmailInUseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ця електронна пошта вже використовується.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Не вдалося змінити інформацію про користувача.");
        }
    }

    /**
     * Deletes the user with the specified user ID.
     *
     * @param id The ID of the user to be deleted.
     * @return ResponseEntity with a success message if the user is deleted successfully,
     *         or a bad request with an error message if there is a server error.
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Користувач був видалений успішно.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Не вдалося видалити користувача");
        }
    }

    /**
     * Changes the password for the user with the specified ID.
     *
     * @param request The change password request containing the user ID, old password, and new password.
     * @return ResponseEntity with a success message if the password is changed successfully,
     *         or a not found response if the user is not found, or a bad request with an error message
     *         if there are validation or server errors.
     */
    @PutMapping("/users/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO request) {
        try {
            userService.changePassword(request.getId(), request.getOldPassword(), request.getNewPassword());
            return ResponseEntity.ok("Пароль був змінений успішно!");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidOldPasswordException e) {
            e.printStackTrace();
            String errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            return ResponseEntity.badRequest().body(errorCode + ": " + errorMessage);
        } catch (WrongPasswordFormat e) {
            e.printStackTrace();
            String errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            return ResponseEntity.badRequest().body(errorCode + ": " + errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Не вдалося змінити пароль.");
        }
    }
}
