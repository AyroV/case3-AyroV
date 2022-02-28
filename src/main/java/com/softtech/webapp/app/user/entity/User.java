package com.softtech.webapp.app.user.entity;

import com.softtech.webapp.app.gen.entity.BaseEntity;
import com.softtech.webapp.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "UserGen" , sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "UserGen")
    private Long id;
    private String username;
    private String usernameUpper;
    private String phoneNumber;
    private String userMail;
    private String userMailUpper;
    private UserType userType;
}
