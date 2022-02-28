package com.softtech.webapp.app.gen.exceptions;

import com.softtech.webapp.app.gen.enums.IErrorMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    private final IErrorMessage errorMessage;
}
