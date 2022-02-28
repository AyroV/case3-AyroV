package com.softtech.webapp.app.user.dao;

import com.softtech.webapp.app.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameUpper(String username);
    User findByPhoneNumber(String phoneNumber);
    User findByUserMailUpper(String userMail);
}
