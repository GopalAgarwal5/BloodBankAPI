package com.bloodbankapp.boodbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private boolean manager = false;
    private String discription;
    private String position;
    private String userRoll;
    private Integer rollId;
    private String password;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Address> address;

}

