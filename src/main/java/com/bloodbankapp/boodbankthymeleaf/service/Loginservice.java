package com.bloodbankapp.boodbankthymeleaf.service;

import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginRes;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface Loginservice {
    ResponseEntity<UserLoginRes> varifyUser(UserLoginReq userLoginReq);
    Map<String, Long> bloodgroupCount();
}
