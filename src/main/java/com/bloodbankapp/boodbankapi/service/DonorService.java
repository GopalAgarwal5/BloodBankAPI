package com.bloodbankapp.boodbankapi.service;

import com.bloodbankapp.boodbankapi.dto.BloodGroupDTO;
import com.bloodbankapp.boodbankapi.entity.Donor;

import java.util.List;

public interface DonorService {
    Donor save(Donor donor);

    List<Donor> findAll();

    Donor findById(int id);

    void deleteById(int id);

    List<BloodGroupDTO>BloodGroupCount();
}
