package com.richards.loginAuthentication.exceptions;

import lombok.Getter;
import lombok.Setter;


@Getter

public enum ExceptionMessage  {

    USER_WITH_EMAIL_NOT_FOUND_EXCEPTION("user with email %s not found");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;

    }

    public void setMessage(String message) {
        this.message = message;
    }
}
