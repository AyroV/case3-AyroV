package com.softtech.webapp.app.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDeleteDto {
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotNull(message = "Phone Number cannot be null")
    @NotBlank(message = "Phone Number cannot be blank")
    private String phoneNumber;
}
