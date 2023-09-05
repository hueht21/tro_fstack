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

    areaEntity.setProvinceId(String.format("%02d", Long.parseLong(dto.getIdProvince())));
    areaEntity.setDistrictId(String.format("%03d",Long.parseLong(dto.getIdDistrict())));
    areaEntity.setWardId(String.format("%05d",Long.parseLong(dto.getIdWard())));
    areaEntity.setExactAddress(dto.getExactAddress());
    return areaConverter.toDTO( areaRepository.saveAndFlush(areaEntity));
  }


  @Override
  public AreaDTOLandLord getArea(long id) {
    AreaEntityLandLord areaEntity = areaRepository.findById(id).get();
    return areaConverter.toDTO(areaEntity);
  }

  @Override
  public AreaDTOLandLord updateArea(AreaDTOLandLord areaDTO, long id) {
    if (areaDTO != null) {
      AreaEntityLandLord areaEntity = areaRepository.getAreaByPostId(id);
      if (areaEntity != null) {
        areaEntity.setName(areaDTO.getName());
        areaEntity.setLongitude(areaDTO.getLongitude());
        areaEntity.setLongitude(areaDTO.getLongitude());
        areaEntity.setExactAddress(areaDTO.getExactAddress());
        areaEntity.setLatitude(areaDTO.getLatitude());
        areaEntity.setProvinceId(String.format("%02d", Long.parseLong(areaDTO.getIdProvince())));
        areaEntity.setDistrictId(String.format("%03d",Long.parseLong(areaDTO.getIdDistrict())));
        areaEntity.setWardId(String.format("%05d",Long.parseLong(areaDTO.getIdWard())));
        areaRepository.save(areaEntity);
      }
    }
    return areaDTO;
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
