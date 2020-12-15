package com.ipc.openIdService.service;

import com.ipc.openIdService.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginWithGoogle {

     String loginWithGoogle(String email);

     String getUserId(String email);

}
