package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTOLandLord extends BaseDTOLandLord {
    private Float depositAmount;

    private Date createdAt;

    private Long idUser;
}
