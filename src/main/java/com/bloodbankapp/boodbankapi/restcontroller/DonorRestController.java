package com.bloodbankapp.boodbankapi.restcontroller;

import com.bloodbankapp.boodbankapi.dto.BloodGroupDTO;
import com.bloodbankapp.boodbankapi.entity.Donor;
import com.bloodbankapp.boodbankapi.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorRestController {

    @Autowired
    private DonorService donorService;

    @PostMapping("/create")
    public Donor addDonor(@RequestBody Donor donor) {
        Donor dbDonor = donorService.save(donor);
        return dbDonor;
    }

    @GetMapping("/findall")
    public List<Donor> getDonors() {
        return donorService.findAll();
    }

    @GetMapping("/find/{id}")
    public Donor getDonor(@PathVariable int id) {
        Donor donor = donorService.findById(id);

        if (donor == null)
            throw new RuntimeException("Donor id not found " + id);
        return donor;
    }

    @PutMapping("/update")
    public Donor updateDonor(@RequestBody Donor donor) {
        return donorService.save(donor);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteDonor(@PathVariable int id) {
        Donor dbDonor = donorService.findById(id);
        if (dbDonor == null)
            throw new RuntimeException("Donor id not found" + id);
        donorService.deleteById(id);
        return "Delete Donor - " + id;
    }

    @GetMapping("/groupCount")
    public List<BloodGroupDTO> GroupCount() {
        return donorService.BloodGroupCount();
    }
}
