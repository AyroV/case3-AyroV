package com.softtech.webapp.app.gen.exceptions;

import com.softtech.webapp.app.gen.enums.IErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {
    public ItemNotFoundException(IErrorMessage message) {
        super(message);
    }
}
