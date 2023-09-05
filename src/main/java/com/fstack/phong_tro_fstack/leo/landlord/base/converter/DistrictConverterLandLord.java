package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.DistrictDTO;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.DistrictEntityLandLord;
import org.springframework.stereotype.Component;

@Component
public class DistrictConverterLandLord {
    public DistrictEntityLandLord toEntity(DistrictDTO districtDTO){
        DistrictEntityLandLord districtEntity=new DistrictEntityLandLord();
        districtEntity.setId(districtDTO.getId());
        districtEntity.setName(districtDTO.getName());
        districtEntity.setType(districtDTO.getType());
        districtEntity.setProvinceId(districtDTO.getIdProvince());
        return districtEntity;
    }

    public DistrictDTO toDTO(DistrictEntityLandLord districtEntity){
        DistrictDTO districtDTO=new DistrictDTO();
        districtDTO.setId(districtEntity.getId());
        districtDTO.setName(districtEntity.getName());
        districtDTO.setType(districtEntity.getType());
        districtDTO.setIdProvince(districtEntity.getProvinceId());
        return districtDTO;
    }
}
