package com.bloodbankapp.boodbankapi.service;

import com.bloodbankapp.boodbankapi.entity.Organization;

import java.util.List;

public interface OrganizationService {
    Organization save(Organization organization);

    List<Organization> findAll();

    Organization findById(int id);

    void deleteById(int id);

}
