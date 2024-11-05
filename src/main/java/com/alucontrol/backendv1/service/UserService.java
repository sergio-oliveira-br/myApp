package com.alucontrol.backendv1.service;

import com.alucontrol.backendv1.exception.DuplicateUserException;
import com.alucontrol.backendv1.model.UserAccout;
import com.alucontrol.backendv1.repository.UserRepository;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAccout saveNewUser(UserAccout newUserAccout) {

        // Caso o username exista, será lançamento a exceção e o processo será interrompido.
        ensureUserDoesNotExist(newUserAccout.getUsername());

        // Realiza o processo de codificação, e configura no DB.
        newUserAccout.setPassword(hashPassword(newUserAccout.getPassword()));

        // Perciste os dados no DB
        LoggerUtil.info("User saved successfully");
        return userRepository.save(newUserAccout);
    }

    // Responsável por criptografar a senha do usuário
    public String hashPassword(String userPassword) {

        if (userPassword == null || userPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        return passwordEncoder.encode(userPassword);
    }

    // Responsável por garantir que o nome de usuário não exista já no banco
    public void ensureUserDoesNotExist(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {throw new DuplicateUserException("Username " + username + " already exists");
        });
    }
}
