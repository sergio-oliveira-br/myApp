package com.alucontrol.backendv1.controllers.user;

import com.alucontrol.backendv1.model.UserAccout;
import com.alucontrol.backendv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    private final UserService userService;

    @Autowired
    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para criar um novo usuário
    @PutMapping()
    public ResponseEntity<UserAccout> createUser(@RequestBody UserAccout newUser) {
        UserAccout createUser = userService.saveNewUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }
}
