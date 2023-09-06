package com.fstack.phong_tro_fstack.leo.landlord.controller;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.AreaDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostRequestDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.RoomDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.common.CommonLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.AreaServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.PostServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.RoomServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.UserServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/leo")
@AllArgsConstructor
public class LandlordController {
  private final AreaServiceLandLord areaService;
  private final PostServiceLandLord postService;
  private final RoomServiceLandLord roomService;

  private final UserServiceLandLord userService;


  @GetMapping("/update-post-news")
  public String updatePost(ModelMap modelMap, Model model, @RequestParam("id") long id) {
    PostRequestDTOLandLord postRequestDTO=new PostRequestDTOLandLord();
    CommonLandLord common = new CommonLandLord();
    AreaDTOLandLord areaDTO = areaService.getAreaByPostId(id);
    PostDTOLandLord postDTO= postService.getPostById(id);
    List<RoomDTOLandLord> roomDTOs=roomService.getRoombyPostId(id);
    int soPhong=0;
    List<List<String>> imageRoomsList = new ArrayList<>();
    for (RoomDTOLandLord roomDTO : roomDTOs) {
      soPhong++;
      List<String> imageList = common.getListImage(roomDTO.getImage());
      imageRoomsList.add(imageList);
    }
    model.addAttribute("imageRoomsList", imageRoomsList);
    postRequestDTO.setSoPhong(soPhong);
    postDTO.setThumbnail(common.geturlthumbnail(postDTO.getThumbnail()));
    postRequestDTO.setAreaDTO(areaDTO);
    postRequestDTO.setPostDTO(postDTO);
    postRequestDTO.setRoomDTOList(roomDTOs);
    modelMap.addAttribute("area", postRequestDTO);
    return "landlord/post-edit";
  }

  @GetMapping("/post-news")
  public String post_news() {
    return "landlord/post-news";
  }
  @GetMapping("/manage-post")
  public String manage_post() {
    return "landlord/manage-post";
  }

  @GetMapping("/profile")
  public String profile() {
    return "landlord/profile";
  }

  @GetMapping("/sign-in")
  public String sign_in() {
    return "landlord/sign-in";
  }

  @GetMapping("/profile-edit")
  public String profile_edit() {
    return "landlord/profile-edit";
  }

  @GetMapping("/account-balance")
  public String account_balance() {
    return "landlord/account-balance";
  }

  @GetMapping("/chat")
  public String chat() {
    return "landlord/chat";
  }
}
