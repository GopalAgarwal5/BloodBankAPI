package com.bloodbankapp.boodbankapi.serviceimpl;

import com.bloodbankapp.boodbankapi.entity.Donor;
import com.bloodbankapp.boodbankapi.repository.DonorRepository;
import com.bloodbankapp.boodbankapi.service.DonorService;
import com.bloodbankapp.boodbankapi.dto.BloodGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {


    @Autowired
    private DonorRepository donorRepository;

    @Override
    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public Donor findById(int id) {
        Optional<Donor> temp = donorRepository.findById(id);
        Donor donor = null;
        if (temp.isPresent()) {
            donor = temp.get();
        } else {
            throw new RuntimeException(" did not find Donor detail");
        }
        return donor;
    }

    @Override
    public void deleteById(int id) {
        donorRepository.deleteById(id);
    }

    @Override
    public List<BloodGroupDTO> BloodGroupCount() {
        return donorRepository.getBloodGroupCount();
//        return donorRepository.getBloodGroupCount().stream().collect(Collectors.toMap(BloodGroupCountDTO::getBloodGroup,BloodGroupCountDTO::getCount));

    }
}
