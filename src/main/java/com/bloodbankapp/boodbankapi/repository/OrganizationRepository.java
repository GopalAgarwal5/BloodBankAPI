package com.bloodbankapp.boodbankapi.repository;

import com.bloodbankapp.boodbankapi.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
    //additional methods
}
