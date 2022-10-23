package com.eukolos.restaurant.exception;

import com.eukolos.restaurant.controler.errors.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException implements ErrorCode {

    public NotFoundException(final String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "NE-001";
    }
}