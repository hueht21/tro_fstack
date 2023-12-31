package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTOLandLord extends BaseDTOLandLord {
    private String name;

    private String image;

    private String video;

    private Float electricService;

    private Float waterService;

    private Float rentPrice;

    private Float acreage;

    private String description;

    private Long idArea;
}
