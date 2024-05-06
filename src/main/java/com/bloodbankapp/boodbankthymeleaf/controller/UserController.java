package com.bloodbankapp.boodbankthymeleaf.controller;

import com.bloodbankapp.boodbankapi.entity.Donor;
import com.bloodbankapp.boodbankapi.service.DonorService;
import com.bloodbankapp.boodbankthymeleaf.dto.DonorFormDTO;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginRes;
import com.bloodbankapp.boodbankthymeleaf.service.Loginservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Loginservice loginservice;
    private HttpSession httpSession;
    private DonorService donorService;

    @Autowired
    public UserController(Loginservice loginservice, HttpSession httpSession, DonorService donorService) {
        this.loginservice = loginservice;
        this.httpSession = httpSession;
        this.donorService = donorService;
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userLoginReq", new UserLoginReq());
        return "login";
    }

    @PostMapping("/varify")
    public String varify(@ModelAttribute UserLoginReq userLoginReq, Model model) {

        ResponseEntity<UserLoginRes> response = loginservice.varifyUser(userLoginReq);
//        Map<String, Long> bloodGroupCount = donorService.BloodGroupCount();
        loginservice.bloodgroupCount();
        if (response.getStatusCode() == HttpStatus.OK) {
            UserLoginRes userLoginRes = response.getBody();
//            System.out.println(bloodGroupCount.keySet());
//            System.out.println(bloodGroupCount.values());
            httpSession.setAttribute("userLoginRes", userLoginRes);
            model.addAttribute("userLoginRes", httpSession.getAttribute("userLoginRes"));
            model.addAttribute("bloodGroups", bloodGroups());
//            model.addAttribute("bloodGroupCounts" , donorService.BloodGroupCount());
            // Handle successful login and user details
            return "index";
        } else {
            // Handle login failure
            return "redirect:/user/login";
        }
    }

    List<String> bloodGroups() {
        return List.of("A +ve", "B +ve", "AB +ve", "O +ve", "A -ve", "B -ve", "AB -ve", "O -ve");
    }


    @GetMapping("/error")
    public String error1(Model model) {
        model.addAttribute("userLoginRes", httpSession.getAttribute("userLoginRes"));

        return "use/error";
    }

    @GetMapping("/showDonorForm")
    public String showForm(Model model) {
        DonorFormDTO donorFormDTO = new DonorFormDTO();
        model.addAttribute("userLoginRes", httpSession.getAttribute("userLoginRes"));
        model.addAttribute("donorFormDTO", donorFormDTO);
        return "user/addDonor";
    }

    @GetMapping("/adddonor")
    public String addDonor(@ModelAttribute("donorFormDTO") DonorFormDTO donorFormDTO) {

        return "user/addDonor";
    }

    @GetMapping("/donorlist")
    public String donorList(Model model) {
        List<Donor> donorList = donorService.findAll();
        model.addAttribute("userLoginRes", httpSession.getAttribute("userLoginRes"));
        model.addAttribute("donorList", donorList);
        return "user/donorList";
    }

    @GetMapping("/dashboard")
    public String dashbord(Model model) {
        model.addAttribute("userLoginRes", httpSession.getAttribute("userLoginRes"));
        return "user/index";
    }


}
