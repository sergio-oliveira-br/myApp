package com.alucontrol.backendv1.Exception;

import com.alucontrol.backendv1.Util.LoggerUtil;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<ProblemDetails> handleDataAccessException(DataAccessException ex, HttpServletRequest request) {

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
    public ResponseEntity<ProblemDetails> handleGenericException(Exception ex, HttpServletRequest request) {

        //Correlation ID and Log
        String correlationId = UUID.randomUUID().toString();
        LoggerUtil.error("Error occurred on path: " + request.getRequestURI() + ", with CorrelationId: " + correlationId + ", Error: " + ex.getMessage());

        return buildErrorResponse (
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Erro interno do servidor.",
                ex.getMessage()
        );
    }
}
