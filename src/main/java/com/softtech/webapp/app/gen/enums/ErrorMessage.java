package com.softtech.webapp.app.gen.enums;

public enum ErrorMessage implements IErrorMessage {
    ITEM_NOT_FOUND("Item not found!"),
    RELATION_NOT_FOUND("Item for relation not found!");

    private final String message;
    ErrorMessage(String message) {
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
