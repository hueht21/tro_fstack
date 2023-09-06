package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.RoomDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.RoomEntityLandLord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomCoverterLandLord implements Mapper<RoomEntityLandLord, RoomDTOLandLord> {

  @Autowired
  private ModelMapper modelMapper;

  public RoomDTOLandLord toDTO(RoomEntityLandLord entity) {
    return modelMapper.map(entity, RoomDTOLandLord.class);
  }

  public RoomEntityLandLord toEntity(RoomDTOLandLord dto) {
    return modelMapper.map(dto, RoomEntityLandLord.class);
  }

  public List<RoomEntityLandLord> toListEntity(List<RoomDTOLandLord> roomDTOs) {
    List<RoomEntityLandLord> roomEntityList = new ArrayList<>();
    if (roomDTOs != null) {
      for (RoomDTOLandLord roomDTO : roomDTOs) {
        roomEntityList.add(toEntity(roomDTO));
      }
    }
    return roomEntityList;
  }

  public List<RoomDTOLandLord> toListDTO(List<RoomEntityLandLord> roomEntitys) {
    List<RoomDTOLandLord> roomDTOList = new ArrayList<>();
    if (roomEntitys != null) {
      for (RoomEntityLandLord roomEntity : roomEntitys) {
        roomDTOList.add(toDTO(roomEntity));
      }
    }
    return roomDTOList;
  }
}
