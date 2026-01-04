package com.bank.exceptions;

import com.bank.payloads.ApiResponse;
import com.bank.payloads.InvalidPassResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFound ex) {
        String msg = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(msg, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<InvalidPassResponse> exceptionHandler(BadCredentialsException ex) {
        InvalidPassResponse response = InvalidPassResponse.builder().response(ex.getMessage()).build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> generalException(Exception ex) {
        String msg = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(msg, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
