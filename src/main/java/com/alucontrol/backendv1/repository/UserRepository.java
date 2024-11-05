package com.alucontrol.backendv1.repository;

import com.alucontrol.backendv1.model.UserAccout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccout, Long> {
    Optional<UserAccout> findByUsername(String username);
}
