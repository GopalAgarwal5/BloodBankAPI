package com.bloodbankapp.boodbankthymeleaf.controller;

import com.bloodbankapp.boodbankthymeleaf.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nav")
public class navigateController {

    @Autowired
    private final Loginservice loginservice;

    public navigateController(Loginservice loginservice) {
        this.loginservice = loginservice;
    }

    @GetMapping("/error")
    public String error1() {
        return "404";
    }

    @GetMapping("/adddonor")
    public String addDonor(Model model) {
        return "addDonor";
    }
}
