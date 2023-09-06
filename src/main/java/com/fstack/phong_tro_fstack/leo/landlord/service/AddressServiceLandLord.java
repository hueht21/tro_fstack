package com.fstack.phong_tro_fstack.leo.landlord.service;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.DistrictDTO;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.ProvinceDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.dto.WardDTOLandLord;

import java.util.List;

public interface AddressServiceLandLord {
    List<ProvinceDTOLandLord> getProvince();
    List<WardDTOLandLord> getWard(long id);
    List<DistrictDTO> getDistrict();

}
