package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.AreaDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.AreaEntityLandLord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AreaConverterLandLord implements Mapper<AreaEntityLandLord, AreaDTOLandLord> {

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public AreaEntityLandLord toEntity(AreaDTOLandLord dto) {
    return modelMapper.map(dto, AreaEntityLandLord.class);
  }

  @Override
  public AreaDTOLandLord toDTO(AreaEntityLandLord entity) {
    return modelMapper.map(entity, AreaDTOLandLord.class);
  }

  public List<AreaDTOLandLord> toListDTO(List<AreaEntityLandLord> list) {
    List<AreaDTOLandLord> areaDTOList = new ArrayList<>();
    for (AreaEntityLandLord areaEntity : list) {
      areaDTOList.add(toDTO(areaEntity));
    }
    return areaDTOList;
  }
}
