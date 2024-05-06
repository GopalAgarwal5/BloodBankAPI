package com.bloodbankapp.boodbankapi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Donor {
    // private fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private long packetNumber;
    private int age;
    private String email;
    private String bloodGroup;
    private String adhaarNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    List<Address> address;

//    //addition methods
//    public void add(Address address) {
//        if (addresses == null)
//            addresses = new ArrayList<>();
//        addresses.add(address);
//    }
}
