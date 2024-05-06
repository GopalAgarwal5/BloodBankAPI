package com.bloodbankapp.boodbankthymeleaf.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginReq {

    private String email;
    private String password;

}
