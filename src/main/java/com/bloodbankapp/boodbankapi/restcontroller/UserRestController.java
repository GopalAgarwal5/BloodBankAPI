package com.bloodbankapp.boodbankapi.restcontroller;

import com.bloodbankapp.boodbankapi.entity.User;
import com.bloodbankapp.boodbankapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User addUser(@RequestBody User user) {
        int id  = userService.findUserRollId(user.getUserRoll());
        user.setRollId(id);
        System.out.println(" is Manager"+user.isManager());
//        if(user.isManager() == true)
//            user.setRollId(id);
//        else
//            user.setRollId(null);

        User dbUser = userService.save(user);
        return dbUser;
    }

    @GetMapping("/findall")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/find/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.findById(id);

        if (user == null)
            throw new RuntimeException("User id not found " + id);
        return user;
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteUser(@PathVariable int id) {
        User dbUser = userService.findById(id);
        if (dbUser == null)
            throw new RuntimeException("User id not found" + id);
        userService.deleteById(id);
        return "Delete User - " + id;
    }

}
