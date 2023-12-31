package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class PostReponseDTOLandLord {
  private String idPost;
  private String name;
  private String idProvince;
  private String latitude;
  private String longitude;
  private String idDistrict;
  private String idWard;
  private String exactAddress;

  List<RoomDTOLandLord> roomDTOList;

  private String idArea;
  private String thumbnail;
  private String title;
  private String content;
  private String phoneNumber;
  private String phoneZalo;
  private Date createdTime;
  private Date createdAt;
  private String numberDate;
  private int status;

  private Long idUser;

}
