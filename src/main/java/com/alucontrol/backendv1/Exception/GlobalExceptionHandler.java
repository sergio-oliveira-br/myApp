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

package com.alucontrol.backendv1.Exception;

import com.alucontrol.backendv1.Util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Capture exceptions thrown anywhere in the application
 *                  ---
 * This approach ensures that the application
 * handles exceptions consistently and robustly,
 * improving the reliability and usability of the system.*/
@ControllerAdvice
public class GlobalExceptionHandler {

    //Metodo auxiliar para construir a resposta de erro ProblemDetails na qual será apresentado ao usuario.
    public ResponseEntity<ProblemDetails> buildErrorResponse  (HttpStatus status,
                                                               String title,
                                                               String details,
                                                               String instance) {
        ProblemDetails problemDetails = new ProblemDetails(
                status.value(),
                "https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status/" + status.value(),
                title,
                details,
                instance
        );
        return new ResponseEntity<>(problemDetails, status);
    }


    //Handles exceptions from resources not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ProblemDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {

        return buildErrorResponse (
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado. ",
                ex.getMessage(),
                ex.getLocalizedMessage()
        );
    }

    //Handles all other generic exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ProblemDetails> handleGenericException(Exception ex) {

        return buildErrorResponse (
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno do servidor.",
                ex.getMessage(),
                ex.getLocalizedMessage()
        );
    }
}
