package com.softtech.webapp.app.user.dto;

import com.softtech.webapp.app.user.enums.UserType;
import lombok.Data;

@Data
public class UserGetDto {
    private Long id;
    private String username;
    private String phoneNumber;
    private String userMail;
    private UserType userType;
    private String createDate;
    private String createdBy;
    private String updateDate;
    private String updatedBy;
}
