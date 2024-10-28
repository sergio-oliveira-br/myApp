package com.alucontrol.backendv1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// This represents a customer entity in the application
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente não pode estar vazio")
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String additionalInfo;

    private String city;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }




    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

