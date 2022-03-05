package com.softtech.webapp.app.user.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum UserErrorMessage implements IErrorMessage {
    USERNAME_ALREADY_TAKEN("This username is already exists!"),
    PHONE_NUMBER_ALREADY_TAKEN("This phone number is already exists!"),
    MAIL_ALREADY_TAKEN("This e-mail is already exists!"),
    ID_USERNAME_NOT_MATCH("Given id and username doesn't match"),
    USERNAME_PHONE_NOT_MATCH("Given username and phone number doesn't match")
    ;

    private final String message;
    private String updatedMessage;
    UserErrorMessage(String message) {
        this.message = message;
        this.updatedMessage = null;
    }

    @Override
    public String getMessage() {
        if (updatedMessage != null)
            return updatedMessage;
        else
            return message;
    }

    @Override
    public String toString() {
        if (updatedMessage != null)
            return updatedMessage;
        else
            return message;
    }

    @Override
    public void concatMessage(String concatString) {
        this.updatedMessage = this.message + " " + concatString;
    }
}
