package com.example.student_management_be.exception.response;

import java.util.Map;

public class ErrorResponse {
    
    private String message;
    private Map<String, String> errors;

    public ErrorResponse (String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
