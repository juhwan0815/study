package study.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.exeption.DuplicateException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DuplicateException.class)
    public String studyExceptionHandling(DuplicateException ex){
        return ex.getMessage();
    }
}
