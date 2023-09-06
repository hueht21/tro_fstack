package com.fstack.phong_tro_fstack.leo.landlord.controller;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.*;
import com.fstack.phong_tro_fstack.leo.landlord.service.PostServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.RoomServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.impl.AreaServiceImplementLandLord;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leo")
@AllArgsConstructor
public class PostManageController {

  private final AreaServiceImplementLandLord areaService;
  private final RoomServiceLandLord roomService;
  private final PostServiceLandLord postService;


  @RequestMapping(value = "/PostNews/save-post-news")
  public ResponseEntity<PostReponseDTOLandLord> savePost(@RequestBody PostReponseDTOLandLord dto,
                                                         HttpSession session) {
    Long idUser = (Long) session.getAttribute("idUser");
    dto.setIdUser(idUser);
    dto.setThumbnail((String) session.getAttribute("one-image"));
    AreaDTOLandLord areaDTO = areaService.saveArea(dto);
    if(areaDTO.getId()<=0){
      areaDTO = areaService.saveArea(dto);
      dto.setIdArea(String.valueOf(areaDTO.getId()));
    }else{
      dto.setIdArea(String.valueOf(areaDTO.getId()));
    }
    int i = 1;
    for (RoomDTOLandLord room : dto.getRoomDTOList()) {
      String imageUrl = (String) session.getAttribute("list-image" + i);
      room.setIdArea(Long.valueOf(dto.getIdArea()));
      room.setImage(imageUrl);
      i++;
    }
    roomService.saveRoom(dto);
    postService.savePost(dto);
    return ResponseEntity.ok(dto);
  }

  @PutMapping(value = "/PostNews/update-post-news")
  public ResponseEntity<?> UpdatePost(@RequestBody PostReponseDTOLandLord dto,
      HttpSession session) {
    long id = Long.parseLong(dto.getIdPost());
    Long idArea = areaService.getAreaByPostId(id).getId();
    List<Long> idRooms = roomService.getRoombyPostId(id).stream().map(BaseDTOLandLord::getId).distinct().collect(
        Collectors.toList());
    dto.setThumbnail((String) session.getAttribute("one-image"));
    dto.setIdArea(String.valueOf(idArea));
    for (int i = 0; i < dto.getRoomDTOList().size(); i++) {
      dto.getRoomDTOList().get(i).setImage(String.valueOf(session.getAttribute("list-image"+(i+1))));
      dto.getRoomDTOList().get(i).setId(idRooms.get(i));
      dto.getRoomDTOList().get(i).setIdArea(idArea);
    }
    roomService.saveRoom(dto);
    postService.savePost(dto);
    return ResponseEntity.ok(dto);
  }


}
