package com.softtech.webapp.app.comment.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum CommentErrorMessage implements IErrorMessage {
    USERNAME_NOT_EXIST("This user doesn't exist!"),
    PRODUCT_NOT_EXIST("This product doesn't exist!"),
    NO_USER_COMMENT("This user has no comment!"),
    NO_PRODUCT_COMMENT("This product doesn't have any comment!")
    ;

    private final String message;
    CommentErrorMessage(String message) {
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
