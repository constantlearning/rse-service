package com.example.rseservice.service.exception;

import org.springframework.http.HttpStatus;

public class ClientAlreadyExistException extends BusinessException {


    public ClientAlreadyExistException(String code, HttpStatus httpStatus) {
        super("clients-5", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
