package com.seuprojeto.contacts_api.resource.exeptions;

import com.seuprojeto.contacts_api.services.exeptions.DatabaseException;
import com.seuprojeto.contacts_api.services.exeptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> ResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> dataBaseException(DatabaseException e, HttpServletRequest request) {
        String error = "DataBase Error";
         HttpStatus status = HttpStatus.BAD_REQUEST;
         StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
         return ResponseEntity.status(status).body(err);
    }
}
