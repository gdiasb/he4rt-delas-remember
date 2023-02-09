package com.dias.he4rt_delas_remember.infrastructure.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleExceptionNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<CustomExceptionHandlerDTO>> handleBadRequest(MethodArgumentNotValidException argumentNotValidException) {
        List<CustomExceptionHandlerDTO> fieldErrors =
                argumentNotValidException.getFieldErrors().stream().map(CustomExceptionHandlerDTO::new).toList();

        return ResponseEntity.badRequest().body(fieldErrors);
    }
}


