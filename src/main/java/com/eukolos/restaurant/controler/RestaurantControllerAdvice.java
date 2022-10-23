package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.controler.errors.RestaurantError;
import com.eukolos.restaurant.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestaurantControllerAdvice {

    @Value("https://eukolos.sendreport.com")
    private String sendReportUri;

    @Value("0.0.1")
    private String currentApiVersion;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestaurantError> handleNotFoundException(HttpServletRequest request,
                                                                   NotFoundException ex) {
        final  RestaurantError error = new RestaurantError(
                currentApiVersion,
                ex.getErrorCode(),
                "this id didnt find",
                "not-found-exception",
                "we didnt find id in domain",
                "try again",
                sendReportUri
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
