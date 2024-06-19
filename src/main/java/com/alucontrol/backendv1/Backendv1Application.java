/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */
package com.alucontrol.backendv1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Backendv1Application
{
    public static void main(String[] args) {
        SpringApplication.run(Backendv1Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("Server is running on port " + System.getenv("PORT"));
        };
    }
}