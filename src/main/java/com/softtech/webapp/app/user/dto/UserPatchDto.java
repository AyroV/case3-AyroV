package com.softtech.webapp.app.user.dto;
import com.softtech.webapp.app.user.enums.UserType;
import lombok.Data;

@Data
public class UserPatchDto {
    private String username;
    private String phoneNumber;
    private String userMail;
    private UserType userType;
}
