package com.mogaco.what_was_it_backend.global.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {

    int getErrorCode();
    HttpStatus getHttpStatus();
    String getErrorMessage();


}
