package com.softtech.webapp.app.user.service;

import com.softtech.webapp.app.gen.enums.ErrorMessage;
import com.softtech.webapp.app.gen.exceptions.BusinessException;
import com.softtech.webapp.app.gen.exceptions.ItemNotFoundException;
import com.softtech.webapp.app.user.dto.UserDeleteDto;
import com.softtech.webapp.app.user.dto.UserGetDto;
import com.softtech.webapp.app.user.dto.UserPatchDto;
import com.softtech.webapp.app.user.dto.UserPostDto;
import com.softtech.webapp.app.user.entity.User;
import com.softtech.webapp.app.user.enums.UserErrorMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;
    private final ModelMapper mapper;

    public List<UserGetDto> findAll() {
        List<User> userList = userEntityService.findAll();
        List<UserGetDto> userGetDtoList = userList.stream().map(user -> mapper.map(user, UserGetDto.class)).collect(Collectors.toList());
        return userGetDtoList;
    }

    public UserGetDto findById(Long id) {
        User user = userEntityService.getByIdWithControl(id, false);
        return mapper.map(user, UserGetDto.class);
    }

    public UserGetDto findByUsername(String username) {
        User user = userEntityService.findByUsername(username);
        validateUser(user);
        return mapper.map(user, UserGetDto.class);
    }

    public UserGetDto save(UserPostDto userPostDto) {
        isUsernameUnique(userPostDto.getUsername().toUpperCase());
        isPhoneNumberUnique(userPostDto.getPhoneNumber());
        isMailUnique(userPostDto.getUserMail().toUpperCase());

        User user = mapper.map(userPostDto, User.class);
        user.setUsernameUpper(userPostDto.getUsername().toUpperCase());
        user.setUserMailUpper(userPostDto.getUserMail().toUpperCase());
        user = userEntityService.save(user, true, false);

        return mapper.map(user, UserGetDto.class);
    }

    public void delete(UserDeleteDto userDeleteDto) {
        User user = userEntityService.findByUsernameUpper(userDeleteDto.getUsername());
        validateUser(user);
        if(!user.getPhoneNumber().equals(userDeleteDto.getPhoneNumber())) {
            throw new ItemNotFoundException(UserErrorMessage.USERNAME_PHONE_NOT_MATCH);
        }

        userEntityService.delete(user);
    }

    public UserGetDto update(UserPatchDto userPatchDto, Long id) {
        User user = userEntityService.getByIdWithControl(id, false);

        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.map(userPatchDto, user);

        if(userPatchDto.getUsername() != null) {
            user.setUsernameUpper(user.getUsername().toUpperCase());
            isUsernameUnique(user.getUsernameUpper());
        }

        if(userPatchDto.getPhoneNumber() != null)
            isPhoneNumberUnique(user.getPhoneNumber());

        if(userPatchDto.getUserMail() != null) {
            user.setUserMailUpper(user.getUserMail().toUpperCase());
            isMailUnique(user.getUserMailUpper());
        }

        user = userEntityService.save(user, true, true);
        return mapper.map(user, UserGetDto.class);
    }

    private void validateUser(User user) {
        if(user == null)
            throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND);
    }

    private void isUserExist(Long id) {
        boolean isExist = userEntityService.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND);
        }
    }

    private void isUsernameUnique(String username) {
        User user = userEntityService.findByUsernameUpper(username);
        if(user != null)
            throw new BusinessException(UserErrorMessage.USERNAME_ALREADY_TAKEN);
    }

    private void isPhoneNumberUnique(String phoneNumber) {
        User user = userEntityService.findByPhoneNumber(phoneNumber);
        if(user != null)
            throw new BusinessException(UserErrorMessage.PHONE_NUMBER_ALREADY_TAKEN);
    }

    private void isMailUnique(String mail) {
        User user = userEntityService.findByUserMailUpper(mail);
        if(user != null)
            throw new BusinessException(UserErrorMessage.MAIL_ALREADY_TAKEN);
    }
}
