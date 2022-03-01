package com.softtech.webapp.app.product.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum ProductErrorMessage implements IErrorMessage {
    PRODUCT_NAME_ALREADY_TAKEN("This product name is already exists!"),
    PRODUCT_PRICE_BELOW_ZERO("Price can't be lower than 0")
    ;

    private final String message;
    ProductErrorMessage(String message) {
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
