package com.fstack.phong_tro_fstack.leo.landlord.service.impl;

import com.fstack.phong_tro_fstack.leo.landlord.base.converter.PostConverterLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostReponseDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.PostEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.PostRepositoryLandLordLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.PostServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PostServiceImplementLandLord implements PostServiceLandLord {

  private final PostRepositoryLandLordLandLord postRepository;
  private final PostConverterLandLord postConverter;

  @Override
  public PostDTOLandLord savePost(PostReponseDTOLandLord dto) {
    PostDTOLandLord postDTO = new PostDTOLandLord();
    postDTO.setThumbnail(dto.getThumbnail());
    postDTO.setContent(dto.getContent());
    postDTO.setTitle(dto.getTitle());
    postDTO.setStatus(0);
    postDTO.setRatetingStart(postDTO.getRatetingStart());
    postDTO.setThumbnail(dto.getThumbnail());
    postDTO.setPhoneNumber(dto.getPhoneNumber());
    postDTO.setPhoneZalo(dto.getPhoneZalo());
    postDTO.setCreatedTime(dto.getCreatedTime());
    postDTO.setIdArea(Long.valueOf(dto.getIdArea()));
    postDTO.setIdUser(dto.getIdUser());
    postRepository.save(postConverter.toEntity(postDTO));
    return postDTO;
  }


  @Override
  public PostDTOLandLord getPostById(long id) {
    PostEntityLandLord postEntity = postRepository.findById(id).get();
    return postConverter.toDTO(postEntity);
  }

  @Override
  public PostDTOLandLord updatePost(PostDTOLandLord postDTO, long id) {
    if (postDTO != null) {
      PostEntityLandLord postEntity = postRepository.findById(id).get();
      postEntity.setThumbnail(postDTO.getThumbnail());
      postEntity.setContent(postDTO.getContent());
      postEntity.setTitle(postDTO.getTitle());
      postEntity.setStatus(0);
      postEntity.setPhoneNumber(postDTO.getPhoneNumber());
      postEntity.setPhoneZalo(postDTO.getPhoneZalo());
      postDTO = postConverter.toDTO(postEntity);
      postRepository.save(postEntity);
    }
    return postDTO;
  }

  @Override
  public List<PostDTOLandLord> getPostAndRateByUser(long idUser) {
    return postConverter.toListDTOAndRate(postRepository.getPostandRatebyUser(idUser));
  }

  @Override
  public PostDTOLandLord getPostbyAreaId(long idArea) {
    return postConverter.toDTO(postRepository.getPostbyAreaId(idArea));
  }


}
