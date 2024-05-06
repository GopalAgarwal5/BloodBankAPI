package com.bloodbankapp.boodbankapi.serviceimpl;

import com.bloodbankapp.boodbankapi.entity.Organization;
import com.bloodbankapp.boodbankapi.repository.OrganizationRepository;
import com.bloodbankapp.boodbankapi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository orgRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    @Override
    public Organization save(Organization org) {
        return orgRepository.save(org);
    }

    @Override
    public List<Organization> findAll() {
        return orgRepository.findAll();
    }

    @Override
    public Organization findById(int id) {
        Optional<Organization> temp = orgRepository.findById(id);
        Organization org = null;
        if (temp.isPresent()) {
            org = temp.get();
        } else {
            throw new RuntimeException(" did not find Organization detail");
        }
        return org;
    }

    @Override
    public void deleteById(int id) {
        orgRepository.deleteById(id);
    }
}
