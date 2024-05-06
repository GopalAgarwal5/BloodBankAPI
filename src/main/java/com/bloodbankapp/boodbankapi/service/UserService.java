package com.bloodbankapp.boodbankapi.service;

import com.bloodbankapp.boodbankapi.entity.User;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
    int findUserRollId(String userRoll);
    User findUserCredential(UserLoginReq userLoginReq);
}
