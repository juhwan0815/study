package com.example.practicetest.exception.advice;

import com.example.practicetest.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity exceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
