package com.bloodbankapp.boodbankapi.repository;

import com.bloodbankapp.boodbankapi.dto.BloodGroupDTO;
import com.bloodbankapp.boodbankapi.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

    //    @Query("SELECT bloodGroup, COUNT(*) AS frequency FROM Donor GROUP BY bloodGroup")
    @Query("SELECT new com.bloodbankapp.boodbankapi.dto.BloodGroupDTO(d.bloodGroup, COUNT(d.id)) FROM Donor d GROUP BY d.bloodGroup")
    List<BloodGroupDTO> getBloodGroupCount();
}
