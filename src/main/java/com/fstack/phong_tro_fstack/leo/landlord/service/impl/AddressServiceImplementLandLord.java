package com.fstack.phong_tro_fstack.leo.landlord.service.impl;

import com.fstack.phong_tro_fstack.leo.landlord.base.converter.DistrictConverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.converter.ProvinceConverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.converter.WardConverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.DistrictDTO;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.ProvinceDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.WardDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.DistrictEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.ProvinceEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.WardEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.DistrictRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.ProvinceRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.WardRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.AddressServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImplementLandLord implements AddressServiceLandLord {
private final WardConverterLandLord wardConverter;
private final DistrictRepositoryLandLord districtRepository;
private final ProvinceRepositoryLandLord provinceRepository;
private final ProvinceConverterLandLord provinceConverter;
private final WardRepositoryLandLord wardRepository;
private final DistrictConverterLandLord districtConverter;

  @Override
  public List<ProvinceDTOLandLord> getProvince() {
    List<ProvinceEntityLandLord> entityList = provinceRepository.findAllById(
        Collections.singleton(1L));
    return entityList.stream().map(provinceConverter::toDTO).collect(Collectors.toList());
  }

  @Override
  public List<WardDTOLandLord> getWard(long id) {
    List<WardEntityLandLord> entityList = wardRepository.findAllByDistrictId(id);
    return entityList.stream().map(wardConverter::toDTO).collect(Collectors.toList());
  }

  @Override
  public List<DistrictDTO> getDistrict() {
    List<DistrictEntityLandLord> entityList = districtRepository.findAllByProvinceId(1L);
    return entityList.stream().map(districtConverter::toDTO).collect(Collectors.toList());
  }

}
