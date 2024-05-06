package com.bloodbankapp.boodbankthymeleaf.serviceimpl;

import com.bloodbankapp.boodbankthymeleaf.dto.BloodGroupCountDTO;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginReq;
import com.bloodbankapp.boodbankthymeleaf.dto.UserLoginRes;
import com.bloodbankapp.boodbankthymeleaf.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginServiceimp implements Loginservice {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<UserLoginRes> varifyUser(UserLoginReq userLoginReq) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserLoginReq> request = new HttpEntity<UserLoginReq>(userLoginReq, headers);
        try {
            ResponseEntity<UserLoginRes> response = restTemplate.postForEntity("http://localhost:8080/login/auth", request, UserLoginRes.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Api Success");
            } else if (response.getStatusCode().is4xxClientError()) {
                System.out.println("Api Error: " + response.getStatusCodeValue());
            }

            System.out.println("Response Body: " + response.getBody());
            System.out.println("Response Status Code: " + response.getStatusCode());

            return response;
        } catch (HttpClientErrorException.NotFound ex) {
            System.out.println("404 Not Found Error: " + ex.getMessage());
            return ResponseEntity.notFound().build();


        }
    }

    @Override
    public Map<String, Long> bloodgroupCount() {
        return Map.of();
    }

//    @Override
//    public Map<String, Long> bloodgroupCount() {
//        try {
//            String api = "http://localhost:8080/donor/groupCount";
//            ResponseEntity<BloodGroupCountDTO> response = restTemplate.getForEntity(api, BloodGroupCountDTO.class);
//            System.out.println("**********this BloodGroupCountDTO responce body" + response.getBody().getBloodGroup());
//            System.out.println("**********this BloodGroupCountDTO responce body" + response.getBody().getCount());
//            BloodGroupCountDTO bloodGroupCountDTO = response.getBody();
//
//            // Convert BloodGroupCountDTO to Map<String, Long>
//            Map<String, Long> bloodGroupCountMap = new HashMap<>();
//            if (bloodGroupCountDTO != null) {
//                for (a:
//                     bloodGroupCountDTO) {
//
//                }
//                bloodGroupCountDTO.getBloodGroupCountMap().forEach((bloodGroup, count) -> {
//                    bloodGroupCountMap.put(bloodGroup, count);
//                });
//            }
//            if (response.getStatusCode().is2xxSuccessful()) {
//                System.out.println("Api BloodGroupCountDTO Success");
//            } else if (response.getStatusCode().is4xxClientError()) {
//                System.out.println("Api BloodGroupCountDTO Error: " + response.getStatusCodeValue());
//            }
//
//            System.out.println("Response Body: " + response.getBody());
//            System.out.println("Response Status Code: " + response.getStatusCode());
//            return response.getBody().stream().collect(Collectors.toMap(com.bloodbankapp.boodbankapi.dto.BloodGroupCountDTO::getBloodGroup, com.bloodbankapp.boodbankapi.dto.BloodGroupCountDTO::getCount));
//
//            return Map.of();
//        } catch (HttpClientErrorException.NotFound ex) {
//            System.out.println("404 Not Found Error: " + ex.getMessage());
//            return ResponseEntity.notFound().build();
//
//
//        }
//        return Map.of();
//    }


}
