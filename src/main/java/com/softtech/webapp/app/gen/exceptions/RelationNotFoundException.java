package com.softtech.webapp.app.gen.exceptions;

import com.softtech.webapp.app.gen.enums.IErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RelationNotFoundException extends BusinessException {
    public RelationNotFoundException(IErrorMessage message) {
        super(message);
    }
}
