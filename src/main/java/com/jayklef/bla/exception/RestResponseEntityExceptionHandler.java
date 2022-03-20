package com.jayklef.bla.exception;

import com.jayklef.bla.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> BookNotFoundException(BookNotFoundException exception,
                                                              WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(exception.getMessage());
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setTimestamp(Timestamp.from(Instant.now()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> CategoryNotFoundException(CategoryNotFoundException exception,
                                                                  WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(exception.getMessage());
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setTimestamp(Timestamp.from(Instant.now()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
}
