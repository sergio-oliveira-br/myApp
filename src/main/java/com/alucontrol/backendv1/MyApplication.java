package com.alucontrol.backendv1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication
{

    @Bean
    public ApplicationRunner applicationRunner(ServerProperties serverProperties) {
        return args -> {
            int port = serverProperties.getPort();
            System.out.println("Server is running on port " + port);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}