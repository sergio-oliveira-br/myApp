package com.alucontrol.backendv1.exception;

public class DuplicateUserException extends RuntimeException {

    // Adicionar um construtor com causa (Throwable):
    // Possibilita capturar a exceção original (se houver alguma outra exceção interna).
    public DuplicateUserException(String message, Throwable cause) {
        super(message);
    }
}
