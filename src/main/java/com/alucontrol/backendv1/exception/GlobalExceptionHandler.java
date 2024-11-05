package com.alucontrol.backendv1.exception;

import com.alucontrol.backendv1.util.LoggerUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Metodo auxiliar para construir a resposta de erro ProblemDetails na qual será apresentado ao usuario.
    public ResponseEntity<ProblemDetails> buildErrorResponse  (HttpStatus status,
                                                               String title,
                                                               String details){
        ProblemDetails problemDetails = new ProblemDetails (
                status.value(),
                "https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status/" + status.value(),
                title,
                details
        );
        return new ResponseEntity<>(problemDetails, status);
    }


    //Handles exceptions from resources not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {

        //Correlation ID and Log
        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("Error occurred on path: " + request.getRequestURI() + ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse (
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado.",
                ex.getMessage()
        );
    }

    //Handles DataAccessException
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ProblemDetails> handleDataAccessException(DataAccessException ex,
                                                                    HttpServletRequest request) {

        //Correlation ID and Log
        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("Error occurred on path: " + request.getRequestURI() + ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro ao acessar os dados.",
                ex.getMessage()
        );
    }

    //Handles all other generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleGenericException(Exception ex,
                                                                 HttpServletRequest request) {

        //Correlation ID and Log
        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("Error occurred on path: " + request.getRequestURI() + ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse (
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno genérico ",
                ex.getMessage()
        );
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ProblemDetails> handleInternalServerException(InternalServerException ex,
                                                                        HttpServletRequest request) {

        // Correlation ID and Log
        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("Internal server error on path: " + request.getRequestURI() + ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno do servidor.",
                "Ocorreu um erro inesperado. Tente novamente mais tarde."
        );
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ProblemDetails> handleDuplicateUserException(RuntimeException ex,
                                                                       HttpServletRequest request) {

        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("User already exists in the database." + request.getRequestURI() +
                ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse(
                HttpStatus.CONFLICT, //409
                "O cadastro não pode ser realizado.",
                "Tente novamente com outro username."
        );
    }
}
