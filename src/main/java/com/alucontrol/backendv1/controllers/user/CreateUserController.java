package com.alucontrol.backendv1.controllers.user;

import com.alucontrol.backendv1.model.UserAccout;
import com.alucontrol.backendv1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    private final UserService userService;

    @Autowired
    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para criar um novo usuário
    @PostMapping()
    public ResponseEntity<UserAccout> createUser(@Valid @RequestParam String username,
                                                 @Valid @RequestParam String password) {

        UserAccout newUserAccout = new UserAccout();
        newUserAccout.setUsername(username);
        newUserAccout.setPassword(password);

        UserAccout createUser = userService.saveNewUser(newUserAccout);

        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }
}
