package com.softtech.webapp.app.user.service;

import com.softtech.webapp.app.gen.service.BaseEntityService;
import com.softtech.webapp.app.user.dao.UserDao;
import com.softtech.webapp.app.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {
    public UserEntityService(UserDao dao) {
        super(dao);
    }

    public User findByUsername(String username) {
        return getDao().findByUsername(username);
    }

    public User findByUsernameUpper(String username) {
        return getDao().findByUsernameUpper(username);
    }

    public User findByPhoneNumber(String phoneNumber) {
        return getDao().findByPhoneNumber(phoneNumber);
    }

    public User findByUserMailUpper(String userMail) {
        return getDao().findByUserMailUpper(userMail);
    }
}
