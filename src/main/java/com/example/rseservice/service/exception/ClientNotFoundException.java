package com.example.rseservice.service.exception;

import com.example.rseservice.error.handler.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends BusinessException {

    public ClientNotFoundException() {
        super("clients-6", HttpStatus.NOT_FOUND);
    }
}
