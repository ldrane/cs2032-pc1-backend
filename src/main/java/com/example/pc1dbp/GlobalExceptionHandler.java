package com.example.pc1dbp;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Runtime.Exception.class})
    public ProblemDetail genericHandler(RuntimeException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(500);
        problemDetail.setTitle("Server Error");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ProblemDetail conflictHandler(UserAlreadyExistException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(409);
        problemDetail.setTitle("Conflict Error");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    public ProblemDetail conflictHandler(UserAlreadyExistException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(401);
        problemDetail.setTitle("Unauthorized Error");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }
}
