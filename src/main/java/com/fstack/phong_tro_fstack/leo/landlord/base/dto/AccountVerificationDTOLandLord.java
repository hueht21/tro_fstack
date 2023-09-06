package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountVerificationDTOLandLord extends BaseDTOLandLord {
    private String email;

    private String token;

    private Date createdAt;
}
