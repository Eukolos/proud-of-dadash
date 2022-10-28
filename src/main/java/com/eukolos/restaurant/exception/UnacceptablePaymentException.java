package com.eukolos.restaurant.exception;

import com.eukolos.restaurant.controler.errors.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class UnacceptablePaymentException extends RuntimeException implements ErrorCode {

    public UnacceptablePaymentException(final String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "NE-002";
    }
}