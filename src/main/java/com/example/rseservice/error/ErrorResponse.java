package com.example.rseservice.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class ErrorResponse {

    private final int statusCode;
    private final List<ApiError> errors;

    private ErrorResponse(int statusCode, List<ApiError> errors) {
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), errors);
    }

    public static ErrorResponse of(HttpStatus status, ApiError error) {
        return of(status, Collections.singletonList(error));
    }
}
