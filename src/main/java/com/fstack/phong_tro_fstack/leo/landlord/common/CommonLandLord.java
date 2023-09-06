package com.fstack.phong_tro_fstack.leo.landlord.common;

import com.fstack.phong_tro_fstack.leo.landlord.Google.FileResponseLandLord;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonLandLord {

  public String geturlthumbnail(String json) {
    Gson gson = new Gson();
      List<FileResponseLandLord> imageid = gson.fromJson(json, new TypeToken<List<FileResponseLandLord>>() {
      }.getType());
      if(Objects.nonNull(imageid)){
        return "https://drive.google.com/uc?id=" + imageid.get(0).getId();
    }
  return "https://drive.google.com/uc?id=1GuvdKgeNxigC2eIGKoPTu1ke83l4p-dg";
  }

  public List<String> getListImage(String json) {
    List<String> list = new ArrayList<>();
    Gson gson = new Gson();
    List<FileResponseLandLord> imageid = gson.fromJson(json, new TypeToken<List<FileResponseLandLord>>() {
    }.getType());
    if(Objects.nonNull(imageid)){
      for (FileResponseLandLord fileResponse : imageid) {
        list.add("https://drive.google.com/uc?id=" + fileResponse.getId());
      }
    }

    return list;
  }
}
