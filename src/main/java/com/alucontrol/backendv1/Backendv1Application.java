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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Backendv1Application
{
    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(Backendv1Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(ServerProperties serverProperties) {
    return args -> {
            int port = Integer.parseInt(System.getenv("PORT"));
            System.out.println("Server is running on port " + port);
        };
    }
}
