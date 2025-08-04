package com.springmvc.web.service;

import com.springmvc.web.dto.RegistrationDto;
import com.springmvc.web.model.UserEntity;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername (String username);
}
