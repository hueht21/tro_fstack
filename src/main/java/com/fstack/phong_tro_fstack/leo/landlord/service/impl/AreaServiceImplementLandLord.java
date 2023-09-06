package com.fstack.phong_tro_fstack.leo.landlord.service.impl;

import com.fstack.phong_tro_fstack.leo.landlord.base.converter.AreaConverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.AreaDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.AreaEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.AreaRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.AddressServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.AreaServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@Transactional
@AllArgsConstructor
public class AreaServiceImplementLandLord implements AreaServiceLandLord {

  private final AreaRepositoryLandLord areaRepository;
  private final AreaConverterLandLord areaConverter;
  AddressServiceLandLord addressService;

  @Override
  public AreaDTOLandLord saveArea(PostReponseDTOLandLord dto) {
    AreaEntityLandLord areaEntity=new AreaEntityLandLord();
    areaEntity.setName(dto.getName());
    areaEntity.setLongitude(dto.getLongitude());
    areaEntity.setLatitude(dto.getLatitude());

    areaEntity.setProvinceId(String.format("%02d", Long.valueOf(dto.getIdProvince())));
    areaEntity.setDistrictId(String.format("%03d",Long.valueOf(dto.getIdDistrict())));
    areaEntity.setWardId(String.format("%05d",Long.valueOf(dto.getIdWard())));
    areaEntity.setExactAddress(dto.getExactAddress());
    return areaConverter.toDTO( areaRepository.saveAndFlush(areaEntity));
  }


  @Override
  public AreaDTOLandLord getArea(long id) {
    AreaEntityLandLord areaEntity = areaRepository.findById(id).get();
    return areaConverter.toDTO(areaEntity);
  }

  @Override
  public AreaDTOLandLord updateArea(PostReponseDTOLandLord dto) {
    AreaEntityLandLord areaEntity=new AreaEntityLandLord();
    areaEntity.setId(Long.valueOf(dto.getIdArea()));
      areaEntity.setName(dto.getName());
      areaEntity.setLongitude(dto.getLongitude());
      areaEntity.setLatitude(dto.getLatitude());

      areaEntity.setProvinceId(String.format("%02d", Long.valueOf(dto.getIdProvince())));
    areaEntity.setDistrictId(String.format("%03d", Objects.nonNull(dto.getIdDistrict()) ? Long.parseLong(dto.getIdDistrict()) : 4));
      areaEntity.setWardId(String.format("%05d",Objects.nonNull(dto.getIdWard()) ? Long.parseLong(dto.getIdWard()) : 124));
      areaEntity.setExactAddress(dto.getExactAddress());
      return areaConverter.toDTO(areaRepository.save(areaEntity));
    }

  @Override
  public List<AreaDTOLandLord> getAllArea() {
    return areaConverter.toListDTO(areaRepository.findAll());
  }

  @Override
  public AreaDTOLandLord getAreaByPostId(Long postId) {
    return areaConverter.toDTO(areaRepository.getAreaByPostId(postId));
  }

}
