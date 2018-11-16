package com.example.rseservice.service.exception;

import org.springframework.http.HttpStatus;

public class ScriptNotFoundException extends BusinessException {

    public ScriptNotFoundException() {
        super("scripts-3", HttpStatus.NOT_FOUND);
    }
}
