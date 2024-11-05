package com.alucontrol.backendv1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class UserAccout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "It is necessary to provide the username, so please do so.")
    private String username;

    @NotBlank(message = "Please give me the password as it is required.")
    private String password;

    @NotBlank(message = "Please provide a role for the user.")
    private String role = "USER"; // Atribuindo 'USER' como valor padrão

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
