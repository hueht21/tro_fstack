package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.ProvinceDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.ProvinceEntityLandLord;
import org.springframework.stereotype.Component;

@Component
public class ProvinceConverterLandLord {
    public ProvinceEntityLandLord toEntity(ProvinceDTOLandLord provinceDTO){
        ProvinceEntityLandLord provinceEntity=new ProvinceEntityLandLord();
        provinceEntity.setId(provinceDTO.getId());
        provinceEntity.setName(provinceDTO.getName());
        provinceEntity.setType(provinceDTO.getType());
        return provinceEntity;
    }

    public ProvinceDTOLandLord toDTO(ProvinceEntityLandLord provinceEntity){
        ProvinceDTOLandLord provinceDTO=new ProvinceDTOLandLord();
        provinceDTO.setId(provinceEntity.getId());
        provinceDTO.setName(provinceEntity.getName());
        provinceDTO.setType(provinceEntity.getType());
        return provinceDTO;
    }
}
