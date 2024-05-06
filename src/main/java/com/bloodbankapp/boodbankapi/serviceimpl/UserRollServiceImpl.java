package com.bloodbankapp.boodbankapi.serviceimpl;

import com.bloodbankapp.boodbankapi.entity.UserRoll;
import com.bloodbankapp.boodbankapi.repository.UserRollRepository;
import com.bloodbankapp.boodbankapi.service.UserRollService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRollServiceImpl implements UserRollService {

    private UserRollRepository userRollRepository;
    private final EntityManager entityManager;

    @Autowired
    public UserRollServiceImpl(EntityManager entityManager, UserRollRepository userRollRepository) {
        this.entityManager = entityManager;
        this.userRollRepository = userRollRepository;
    }

    @Override
    public int findByUserRoll(String roll) {
        TypedQuery<UserRoll> query = entityManager.createQuery("select r from UserRoll r " +
                "where r.userRoll = :data", UserRoll.class);
        query.setParameter("data", roll);
        UserRoll userRoll = query.getSingleResult();
        return userRoll.getId();
    }

    @Override
    public UserRoll save(UserRoll userRoll) {
        UserRoll roll = userRollRepository.save(userRoll);
        return roll;
    }

}
