package com.piisw.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class GlobalExceptionHandleer {

        @ExceptionHandler (MethodArgumentNotValidException.class)
        public Map<String, String> handleValidationExceptions(
                MethodArgumentNotValidException ex) {
                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                });
                return errors;
        }

        @ExceptionHandler ({HttpStatusCodeException.class})
        public final ResponseEntity<String> handleStatusCodeException(HttpStatusCodeException ex) {
                return new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getResponseHeaders(), ex.getStatusCode());
        }

        @ExceptionHandler ({Exception.class})
        public final ResponseEntity<String> handleUnknownException(Exception ex) {
                return new ResponseEntity<>(
                        "Error has occured. Possible error causes: Fields of Object in request not validated" + ex
                                .getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
        }

}
