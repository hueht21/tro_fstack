package com.fstack.phong_tro_fstack.leo.landlord.service;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.RoomDTOLandLord;

import java.util.List;

public interface RoomServiceLandLord {

  List<RoomDTOLandLord> saveRoom(PostReponseDTOLandLord dto);


  List<RoomDTOLandLord> updateRoom(PostReponseDTOLandLord dto);

  List<RoomDTOLandLord> getRoombyAreaId(long idArea);

  List<RoomDTOLandLord> getRoombyPostId(long idPost);
}
