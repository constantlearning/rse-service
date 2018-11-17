package com.example.rseservice.config.feign.exception;

import com.example.rseservice.error.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class CGIException extends BusinessException {

    public CGIException() {
        super("cgi-1", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public CGIException(String code, HttpStatus httpStatus) {
        super(code, httpStatus);
    }
}
