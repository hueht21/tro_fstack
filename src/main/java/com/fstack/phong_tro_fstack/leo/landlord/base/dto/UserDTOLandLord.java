package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOLandLord extends BaseDTOLandLord {
    private String email;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String idCard;

    private Float balance;

    private Date createdAt;
}
