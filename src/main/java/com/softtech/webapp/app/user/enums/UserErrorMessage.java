package com.softtech.webapp.app.user.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum UserErrorMessage implements IErrorMessage {
    USERNAME_ALREADY_TAKEN("This username is already exists!"),
    PHONE_NUMBER_ALREADY_TAKEN("This phone number is already exists!"),
    MAIL_ALREADY_TAKEN("This e-mail is already exists!"),
    USERNAME_PHONE_NOT_MATCH("Given username and phone number doesn't match")
    ;

    private final String message;
    UserErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
