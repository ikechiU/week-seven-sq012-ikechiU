package com.example.weeksevensq012ikechiu.exception;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field(s)."),
    RECORD_ALREADY_EXIST("Record already exist."),
    INCORRECT_LOGIN_DETAILS("Incorrect login details."),
    NO_RECORD_FOUND("No record found.");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
