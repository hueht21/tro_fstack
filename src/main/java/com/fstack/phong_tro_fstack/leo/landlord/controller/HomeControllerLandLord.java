package com.fstack.phong_tro_fstack.leo.landlord.controller;


import com.fstack.phong_tro_fstack.leo.landlord.base.dto.PostDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.UserDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.common.CommonLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.PostServiceLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.UserServiceLandLord;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/leo")
@AllArgsConstructor
public class HomeControllerLandLord {
  private final PostServiceLandLord postService;

  private final UserServiceLandLord userService;

  @GetMapping({"/home", "/", ""})
  public String homeShowNews(ModelMap modelMap, HttpSession session) {
    Long idUser = (Long) session.getAttribute("idUser");
    List<PostDTOLandLord> postDTOs = postService.getPostAndRateByUser(idUser);
    CommonLandLord common = new CommonLandLord();
    List<PostDTOLandLord> updatedPostDTOs = new ArrayList<>();
    for (PostDTOLandLord post : postDTOs) {
      post.setThumbnail(common.geturlthumbnail(post.getThumbnail()));
      updatedPostDTOs.add(post);
    }
    postDTOs = updatedPostDTOs;
    modelMap.addAttribute("posts", postDTOs);
    return "landlord/home";
  }
  @GetMapping({"", "/"})
  public String homeShowNewss(ModelMap modelMap, HttpSession session, @PathVariable("id") Long id) {
    UserDTOLandLord user = userService.getUser(id);
    session.setAttribute("user", user);
    long idUser = ((UserDTOLandLord) session.getAttribute("user")).getId();
    List<PostDTOLandLord> postDTOs = postService.getPostAndRateByUser(idUser);
    CommonLandLord common = new CommonLandLord();
    List<PostDTOLandLord> updatedPostDTOs = new ArrayList<>();
    if(Objects.nonNull(postDTOs))  {
      for (PostDTOLandLord post : postDTOs) {
        if(Objects.nonNull(post.getThumbnail())){
          post.setThumbnail(common.geturlthumbnail(post.getThumbnail()));
          updatedPostDTOs.add(post);
        }
      }
    }
    postDTOs = updatedPostDTOs;
    modelMap.addAttribute("posts", postDTOs);
    return "landlord/home";
  }
}
