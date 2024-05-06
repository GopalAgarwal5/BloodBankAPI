package com.bloodbankapp.boodbankapi.restcontroller;

import com.bloodbankapp.boodbankapi.entity.User;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginRes;
import com.bloodbankapp.boodbankapi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<UserLoginRes> auth(@RequestBody UserLoginReq userLoginReq) {
        User result = userService.findUserCredential(userLoginReq);
        UserLoginRes userLoginRes1 = new UserLoginRes();
        if (Objects.nonNull(result)) {
            BeanUtils.copyProperties(result, userLoginRes1);
            return ResponseEntity.ok(userLoginRes1);
        } else {
            return ResponseEntity.notFound().build();
        }

//        if (!result.isEmpty()) {
//            User user = resultList.get(0);
//            // Create a ModelMapper instance
//            ModelMapper modelMapper = new ModelMapper();
//            // Map User object to UserLoginRes object
//            UserLoginRes userLoginRes = modelMapper.map(user, UserLoginRes.class);
//            System.out.println("User found: " + user);
//        if ()
//            return ResponseEntity.ok(userLoginRes);
//        } else {
//            System.out.println("User not found");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }

    }

}
