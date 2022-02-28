package com.softtech.webapp.app.user.dto;

import com.softtech.webapp.app.user.enums.UserType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserPatchDto {
    @NotNull(message = "Id cannot be null")
    private Long id;
    private String username;
    private String phoneNumber;
    private String userMail;
}
