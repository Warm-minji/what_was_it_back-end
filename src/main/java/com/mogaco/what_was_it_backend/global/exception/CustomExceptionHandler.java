package com.mogaco.what_was_it_backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity handleBaseEx(BaseException exception) {

        log.error("BaseException errorMessage(): {}", exception.getExceptionType().getErrorMessage());
        log.error("BaseException errorCode(): {}", exception.getExceptionType().getErrorCode());

        return new ResponseEntity(new ExceptionDto(exception.getExceptionType().getErrorCode(), exception.getExceptionType().getErrorMessage()),
                exception.getExceptionType().getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableExceptionEx(HttpMessageNotReadableException exception){

        log.error("Json 파싱 중 예외 발생 {}", exception.getMessage() );
        return new ResponseEntity(new ExceptionDto(700, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    static class ExceptionDto {
        private int errorCode;
        private String errorMessage;
    }
}