package com.bloodbankapp.boodbankthymeleaf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodGroupCountDTO {
    private String bloodGroup;
    private Long count;

    public BloodGroupCountDTO(String bloodGroup, Long count) {
        this.bloodGroup = bloodGroup;
        this.count = count;
    }

    public BloodGroupCountDTO() {
    }
}
