package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcHandler {
 @ExceptionHandler(RuntimeException.class)
 public ResponseEntity<ErrorResponse>handleRuntimeException(RuntimeException ex)
 {
	 return new ResponseEntity<>(new ErrorResponse(ex.getMessage()),HttpStatus.BAD_REQUEST);
 }
	
}
