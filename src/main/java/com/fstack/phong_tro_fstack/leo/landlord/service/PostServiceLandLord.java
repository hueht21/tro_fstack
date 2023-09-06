package com.fstack.phong_tro_fstack.leo.landlord.service;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;

import java.util.List;

public interface PostServiceLandLord {

  PostDTOLandLord savePost(PostReponseDTOLandLord dto);

  PostDTOLandLord getPostById(long id);

  PostDTOLandLord updatePost(PostReponseDTOLandLord postDTO);

  List<PostDTOLandLord> getPostAndRateByUser(long idUser);

  PostDTOLandLord getPostbyAreaId(long idArea);
}
