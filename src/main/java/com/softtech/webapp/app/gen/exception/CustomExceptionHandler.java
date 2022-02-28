package com.softtech.webapp.app.gen.exception;

import com.softtech.webapp.app.gen.exceptions.BusinessException;
import com.softtech.webapp.app.gen.exceptions.ItemNotFoundException;
import com.softtech.webapp.app.gen.exceptions.RelationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        LocalDateTime errorDate = LocalDateTime.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(dateTimeFormatter.format(errorDate), message, description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllBusinessException(BusinessException ex, WebRequest webRequest){

        LocalDateTime errorDate = LocalDateTime.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(dateTimeFormatter.format(errorDate), message, description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest){

        LocalDateTime errorDate = LocalDateTime.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(dateTimeFormatter.format(errorDate), message, description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllRelationNotFoundException(RelationNotFoundException ex, WebRequest webRequest){

        LocalDateTime errorDate = LocalDateTime.now();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(dateTimeFormatter.format(errorDate), message, description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
