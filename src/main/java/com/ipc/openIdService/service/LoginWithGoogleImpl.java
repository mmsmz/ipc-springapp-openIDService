package com.ipc.openIdService.service;

import com.ipc.openIdService.entity.UserEntity;
import com.ipc.openIdService.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginWithGoogleImpl implements LoginWithGoogle{

    /**
     * The Logger
     */
    final Logger logger = LoggerFactory.getLogger(LoginWithGoogleImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public String loginWithGoogle(String email) {
        List<UserEntity> userEntityList = userRepository.findByEmail(email);
        if (userEntityList.isEmpty()) {
            return "http://localhost:4200/google/registration?email="+email; // add params ?email userid
        }
        else{
            return "http://localhost:4200/contact-us";
        }
    }

    @Override
    public String getUserId(String email) {

        List<UserEntity> userNameEntity = userRepository.findByEmail(email);

        return userNameEntity.get(0).getUserId();

    }
}
