package com.example.rseservice.error.handler.api;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
class ApiError {

    private final String code;
    private final String message;

    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}