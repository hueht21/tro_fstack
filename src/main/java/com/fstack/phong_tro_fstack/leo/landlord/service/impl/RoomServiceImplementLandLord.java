package com.fstack.phong_tro_fstack.leo.landlord.service.impl;

import com.fstack.phong_tro_fstack.leo.landlord.base.converter.RoomCoverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.RoomDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.RoomEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.RoomRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.RoomServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RoomServiceImplementLandLord implements RoomServiceLandLord {

  private final RoomRepositoryLandLord roomRepository;
  private final RoomCoverterLandLord roomCoverter;

  @Override
  public List<RoomDTOLandLord> saveRoom(PostReponseDTOLandLord dto) {
    List<RoomEntityLandLord> roomEntities = dto.getRoomDTOList()
        .stream().map(roomCoverter::toEntity)
        .collect(Collectors.toList());
    roomRepository.saveAll(roomEntities);

    return dto.getRoomDTOList();
  }

  @Override
  public List<RoomDTOLandLord> updateRoom(PostReponseDTOLandLord dto) {
    List<RoomEntityLandLord> roomEntities = dto.getRoomDTOList()
        .stream().map(roomCoverter::toEntity)
        .collect(Collectors.toList());
    roomRepository.saveAll(roomEntities);

    return dto.getRoomDTOList();
  }

  @Override
  public List<RoomDTOLandLord> getRoombyAreaId(long idArea) {
    return roomCoverter.toListDTO(roomRepository.getRoombyAreaId(idArea));
  }

  @Override
  public List<RoomDTOLandLord> getRoombyPostId(long idPost) {
    return roomCoverter.toListDTO(roomRepository.getRoombyPostId(idPost));
  }
}
