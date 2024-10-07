package com.alucontrol.backendv1.Exception;


//Esta classe é uma classe de transferencia (DTO),
//na qual estrutura os dados e envia para o cliente. - Essa abordagem é inspirado no RFC 7807
public class ProblemDetails {
    private int status;
    private String type;
    private String title;
    private String details;


    public ProblemDetails(int status, String type, String title, String details) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.details = details;
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

