package com.bloodbankapp.boodbankapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodGroupDTO {
    private String bloodGroup;
    private Long count;

    public BloodGroupDTO(String bloodGroup, Long count) {
        this.bloodGroup = bloodGroup;
        this.count = count;
    }

    public BloodGroupDTO() {
    }
}
