package com.bloodbankapp.boodbankapi.repository;


import com.bloodbankapp.boodbankapi.entity.UserRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRollRepository extends JpaRepository<UserRoll,Integer> {
    //additional methods

}
 