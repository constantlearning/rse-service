package com.example.rseservice.service.exception;

import com.example.rseservice.error.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ScriptNotFoundException extends BusinessException {

    public ScriptNotFoundException() {
        super("scripts-3", HttpStatus.NOT_FOUND);
    }
}
