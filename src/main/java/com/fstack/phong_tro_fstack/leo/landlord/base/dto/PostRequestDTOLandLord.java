package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostRequestDTOLandLord {
    private AreaDTOLandLord areaDTO;
    private List<RoomDTOLandLord> roomDTOList;
    private PostDTOLandLord postDTO;
    private int soPhong;
  }
