package com.bloodbankapp.boodbankthymeleaf.dto;

import com.bloodbankapp.boodbankapi.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLoginRes{
    private int id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String discription;
    private String position;
    private String userRoll;
    private Integer rollId;
    private List<Address> address;
    private String message;
    private int responce;

}
