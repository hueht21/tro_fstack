package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.WardDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.WardEntityLandLord;
import org.springframework.stereotype.Component;

@Component
public class WardConverterLandLord {
    public WardEntityLandLord toEntity(WardDTOLandLord wardDTO){
        WardEntityLandLord wardEntity=new WardEntityLandLord();
        wardEntity.setId(wardDTO.getId());
        wardEntity.setName(wardDTO.getName());
        wardEntity.setType(wardDTO.getType());
        wardEntity.setDistrictId(wardDTO.getIdDistrict());
        return wardEntity;
    }

    public WardDTOLandLord toDTO(WardEntityLandLord wardEntity){
        WardDTOLandLord wardDTO=new WardDTOLandLord();
        wardDTO.setId(wardEntity.getId());
        wardDTO.setName(wardEntity.getName());
        wardDTO.setType(wardEntity.getType());
        wardDTO.setIdDistrict(wardEntity.getDistrictId());
        return wardDTO;
    }
}
