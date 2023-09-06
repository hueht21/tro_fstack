package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaDTOLandLord extends BaseDTOLandLord {
    private String name;

    private String longitude;

    private String latitude;

    private String idProvince;

    private String idDistrict;

    private String idWard;

    private String exactAddress;

}
