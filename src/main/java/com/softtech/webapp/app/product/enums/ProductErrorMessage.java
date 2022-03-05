package com.softtech.webapp.app.product.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum ProductErrorMessage implements IErrorMessage {
    PRODUCT_NAME_ALREADY_TAKEN("This product name is already exists!"),
    PRODUCT_PRICE_BELOW_ZERO("Price can't be lower than 0")
    ;

    private final String message;
    private String updatedMessage;
    ProductErrorMessage(String message) {
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
