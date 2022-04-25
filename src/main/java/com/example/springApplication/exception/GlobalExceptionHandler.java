package com.example.springApplication.exception;

import com.example.springApplication.dto.response.ErrorResponse;
import com.example.springApplication.enums.ExceptionCodes;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Configuring code part with working Swagger.
    public ErrorResponse handling(StudentNotFoundException exception, WebRequest request) {

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .path(request.getContextPath())
                .errorCode(ExceptionCodes.STUDENT_NOT_FOUND_EXCEPTION.getCode())
                .build();
    }

}
