package com.softtech.webapp.app.user.controller;

import com.softtech.webapp.app.user.dto.UserGetDto;
import com.softtech.webapp.app.user.dto.UserPostDto;
import com.softtech.webapp.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<UserGetDto> userGetDtoList = userService.findAll();
        return ResponseEntity.ok().body(userGetDtoList);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserPostDto userPostDto) {
        UserGetDto userGetDto = userService.save(userPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userGetDto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
