package com.mogaco.what_was_it_backend.member.exception;

import com.mogaco.what_was_it_backend.global.exception.BaseException;
import com.mogaco.what_was_it_backend.global.exception.BaseExceptionType;

public class MemberException extends BaseException {

    private BaseExceptionType exceptionType;

    public MemberException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
