package com.bloodbankapp.boodbankthymeleaf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonorFormDTO {
    private int id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private long packetNumber;
    private int age;
    private String email;
    private String bloodGroup;
    private String adhaarNumber;



}
