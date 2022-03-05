package com.softtech.webapp.app.gen.enums;

public enum ErrorMessage implements IErrorMessage {
    ITEM_NOT_FOUND("Item not found!");

    private final String message;
    private String updatedMessage;
    ErrorMessage(String message) {
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
