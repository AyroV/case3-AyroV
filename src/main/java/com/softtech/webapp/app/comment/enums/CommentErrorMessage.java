package com.softtech.webapp.app.comment.enums;

import com.softtech.webapp.app.gen.enums.IErrorMessage;

public enum CommentErrorMessage implements IErrorMessage {
    NO_USER_COMMENT("This user has no comment!"),
    NO_PRODUCT_COMMENT("This product doesn't have any comment!")
    ;

    private final String message;
    private String updatedMessage;
    CommentErrorMessage(String message) {
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
