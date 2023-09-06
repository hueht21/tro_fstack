package com.fstack.phong_tro_fstack.leo.landlord.controller;


import com.fstack.phong_tro_fstack.leo.landlord.base.dto.DistrictDTO;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.ProvinceDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.WardDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.AddressServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leo")
@AllArgsConstructor
public class AddressControllerLandLord {

  private final AddressServiceLandLord addressService;

  //show address.
  @GetMapping("/PostNews/province")
  public ResponseEntity<?> getAddress() {
    List<ProvinceDTOLandLord> result = addressService.getProvince();
    return ResponseEntity.ok(result);
  }


  @GetMapping("/PostNews/district")
  public ResponseEntity<?> getListDistrictByIdProvince() {

    List<DistrictDTO> result = addressService.getDistrict();

    return ResponseEntity.ok(result);
  }

  @GetMapping("/PostNews/ward/{idDistrict}")
  public ResponseEntity<?> getListWardByIdDistrict(@PathVariable long idDistrict) {
    List<WardDTOLandLord> result = addressService.getWard(idDistrict);
    return ResponseEntity.ok(result);
  }





}
