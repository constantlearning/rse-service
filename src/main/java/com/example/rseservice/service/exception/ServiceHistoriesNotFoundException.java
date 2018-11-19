package com.example.rseservice.service.exception;

import com.example.rseservice.error.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ServiceHistoriesNotFoundException extends BusinessException {
    public ServiceHistoriesNotFoundException() {
        super("ServiceHistories not exists", HttpStatus.NOT_FOUND);
    }
}
