package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.PostEntityLandLord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverterLandLord implements Mapper<PostEntityLandLord, PostDTOLandLord> {

  @Autowired
  private ModelMapper modelMapper;

  public PostEntityLandLord toEntity(PostDTOLandLord dto) {
    return modelMapper.map(dto, PostEntityLandLord.class);
  }

  public PostDTOLandLord toDTO(PostEntityLandLord entity) {
    return modelMapper.map(entity, PostDTOLandLord.class);
  }


  public List<PostEntityLandLord> toListEntity(List<PostDTOLandLord> postDTOList) {
    List<PostEntityLandLord> postEntityList = new ArrayList<>();
    for (PostDTOLandLord postDTO : postDTOList) {
      postEntityList.add(toEntity(postDTO));
    }
    return postEntityList;
  }

  public List<PostDTOLandLord> toListDTO(List<PostEntityLandLord> postEntityList) {
    List<PostDTOLandLord> postDTOList = new ArrayList<>();
    for (PostEntityLandLord PostEntity : postEntityList) {
      postDTOList.add(toDTO(PostEntity));
    }
    return postDTOList;
  }

  public List<PostDTOLandLord> toListDTOAndRate(List<Object[]> objects) {
    List<PostDTOLandLord> list = new ArrayList<>();
    for (Object[] result : objects) {
      PostDTOLandLord postDTO = new PostDTOLandLord();
      postDTO.setContent((String) result[0]);
      postDTO.setStatus((int) result[1]);
      postDTO.setTitle((String) result[2]);
      postDTO.setThumbnail((String) result[3]);
      postDTO.setId((long) result[4]);
      // Lấy giá trị ratingStarts từ cột ratingStarts của RateEntity
      postDTO.setRatetingStart(result[5] instanceof Float ? (Float) result[4] : 0f);
      list.add(postDTO);
    }
    return list;
  }

}
