package com.example.rseservice.service.exception;


public class BusinessRuleException extends RuntimeException {

    private String field;
    private String error;

    public BusinessRuleException(String error, String response, String field) {
        super(response);
        this.field = field;
        this.error = error;
    }

    public BusinessRuleException(String error, String response) {
        super(response);
        this.error = error;
    }

    public BusinessRuleException(String response) {
        super(response);
    }

    public String getField() {
        return this.field;
    }

    public String getError() {
        return error;
    }
}
