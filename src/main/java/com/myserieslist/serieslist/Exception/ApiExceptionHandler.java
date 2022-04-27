package com.myserieslist.serieslist.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {EmailNotValid.class})
    public ResponseEntity<Object> handleEmailNotValid(EmailNotValid e) {
        ApiException apiException = new ApiException(e.getMessage(),
                HttpStatus.BAD_REQUEST, 
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SerieExistsInCategory.class})
    public ResponseEntity<Object> handleSerieExistsInCategory(SerieExistsInCategory e) {
        ApiException apiException = new ApiException(e.getMessage(),
                HttpStatus.BAD_REQUEST, 
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
