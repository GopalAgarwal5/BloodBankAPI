package com.bloodbankapp.boodbankapi.serviceimpl;

import com.bloodbankapp.boodbankapi.entity.User;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;
import com.bloodbankapp.boodbankapi.repository.UserRepository;
import com.bloodbankapp.boodbankapi.service.UserRollService;
import com.bloodbankapp.boodbankapi.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserRollService userRollService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRollService userRollService) {
        this.userRepository = userRepository;
        this.userRollService = userRollService;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> temp = userRepository.findById(id);
        User user = null;
        if (temp.isPresent()) {
            user = temp.get();
        } else {
            throw new RuntimeException(" did not find User detail");
        }
        return user;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public int findUserRollId(String userRoll) {
        int id = userRollService.findByUserRoll(userRoll);
        return id;
    }

    @Override
    public  User findUserCredential(UserLoginReq userLoginReq) {
        User user = userRepository.findByEmailAndPassword(userLoginReq.getEmail(), userLoginReq.getPassword());
        System.out.println(" ##user service imp user detail : "+user);
        return user;
    }

}
