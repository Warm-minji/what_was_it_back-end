package com.mogaco.what_was_it_backend.member.exception;

import com.mogaco.what_was_it_backend.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum MemberExceptionType implements BaseExceptionType {
    ALREADY_EXIST_USER(600, HttpStatus.CONFLICT, "이미 존재하는 아이디입니다."),
    NONEXISTENT_ID(601, HttpStatus.UNAUTHORIZED, "존재하지 않는 아이디입니다."),
    WRONG_PASSWORD(602, HttpStatus.UNAUTHORIZED, "비밀번호가 잘못되었습니다."),
    WRONG_ID_OR_PASSWORD(603, HttpStatus.UNAUTHORIZED, "아이디 혹은 비밀번호가 잘못되었습니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    MemberExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
