package com.fstack.phong_tro_fstack.leo.landlord.service;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.AreaDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;

import java.util.List;

public interface AreaServiceLandLord {

  AreaDTOLandLord saveArea(PostReponseDTOLandLord dto);

  AreaDTOLandLord getArea(long id);

  AreaDTOLandLord updateArea(AreaDTOLandLord areaDTO, long id);

  AreaDTOLandLord getAreaByPostId(Long postId);

  List<AreaDTOLandLord> getAllArea();

}
