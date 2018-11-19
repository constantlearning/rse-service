package com.example.rseservice.service.exception;

import com.example.rseservice.error.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ServiceNotFoundException extends BusinessException {

    public ServiceNotFoundException() {
        super("Service not exists", HttpStatus.NOT_FOUND);
    }
}