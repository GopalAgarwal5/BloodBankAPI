package com.bloodbankapp.boodbankapi.restcontroller;

import com.bloodbankapp.boodbankapi.entity.UserRoll;
import com.bloodbankapp.boodbankapi.service.UserRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userroll")
public class UserRollRestController {

    @Autowired
    private UserRollService userRollService;

    @PostMapping("/create")
    public UserRoll addRoll(@RequestBody UserRoll userRoll) {
        UserRoll roll = userRollService.save(userRoll);
        return roll;
    }
}
