package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.UserDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.UserEntityLandLord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverterLandLord implements Mapper<UserEntityLandLord, UserDTOLandLord> {

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public UserEntityLandLord toEntity(UserDTOLandLord dto) {
    return modelMapper.map(dto, UserEntityLandLord.class);
  }

  @Override
  public UserDTOLandLord toDTO(UserEntityLandLord entity) {
    return modelMapper.map(entity, UserDTOLandLord.class);
  }
}
