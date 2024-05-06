package com.bloodbankapp.boodbankapi.restcontroller;

import com.bloodbankapp.boodbankapi.entity.Organization;
import com.bloodbankapp.boodbankapi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationRestController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    public Organization addOrganization(@RequestBody Organization org) {
        Organization dbOrganization = organizationService.save(org);
        return dbOrganization;
    }

    @GetMapping("/findall")
    public List<Organization> getOrganizations() {
        return organizationService.findAll();
    }

    @GetMapping("/find/{id}")
    public Organization getOrganization(@PathVariable int id) {
        Organization organization = organizationService.findById(id);

        if (organization == null)
            throw new RuntimeException("Organization id not found " + id);
        return organization;
    }

    @PutMapping("/update")
    public Organization updateOrganization(@RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteOrganization(@PathVariable int id) {
        Organization dbOrganization = organizationService.findById(id);
        if (dbOrganization == null)
            throw new RuntimeException("Organization id not found" + id);
        organizationService.deleteById(id);
        return "Delete Organization - " + id;
    }

}
