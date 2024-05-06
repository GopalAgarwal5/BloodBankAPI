package com.bloodbankapp.boodbankapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqest {
    private String username;
    private String password;
}
