package com.softtech.webapp.app.user.dto;

import com.softtech.webapp.app.user.enums.UserType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserPostDto {
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotNull(message = "Phone Number cannot be null")
    @NotBlank(message = "Phone Number cannot be blank")
    private String phoneNumber;
    @NotNull(message = "E-Mail cannot be null")
    @NotBlank(message = "E-Mail cannot be blank")
    private String userMail;
    @NotNull(message = "User Type cannot be null")
    private UserType userType;
}
