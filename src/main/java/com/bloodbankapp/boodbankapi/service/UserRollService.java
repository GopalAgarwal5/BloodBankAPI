package com.bloodbankapp.boodbankapi.service;

import com.bloodbankapp.boodbankapi.entity.UserRoll;

public interface UserRollService {
    int findByUserRoll(String roll);
    UserRoll save(UserRoll userRoll);
}
