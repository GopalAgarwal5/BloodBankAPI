package com.bloodbankapp.boodbankapi.repository;

import com.bloodbankapp.boodbankapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);
    //additional methods
}
