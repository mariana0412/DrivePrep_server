package com.phoenixsquad.driveprep_server.repository;

import com.phoenixsquad.driveprep_server.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByEmail(String email);
}
