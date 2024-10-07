package com.alucontrol.backendv1.Exception;

import java.time.Instant;

//Esta classe é uma classe de transferencia (DTO), na qual estrutura os dados
//e envia para o cliente.
public class ApiErrorResponse {
    private int status;
    private String message;
    private String timestamp;

    public ApiErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = Instant.now().toString(); // add timestamp
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

