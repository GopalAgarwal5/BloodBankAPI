package com.bloodbankapp.boodbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    // private fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String addressLine;
    private String city;
    private String state;
    private Long postalCode;
    private String country;

//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//    @JoinColumn(name = "donor_id")
//    private Donor donor;

}
