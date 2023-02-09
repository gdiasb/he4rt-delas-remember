package com.dias.he4rt_delas_remember.infrastructure.exceptions;

import org.springframework.validation.FieldError;

public record CustomExceptionHandlerDTO(String field, String message) {

    public CustomExceptionHandlerDTO(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
