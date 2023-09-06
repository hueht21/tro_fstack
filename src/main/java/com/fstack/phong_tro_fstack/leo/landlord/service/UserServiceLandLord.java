package com.fstack.phong_tro_fstack.leo.landlord.service;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.UserDTOLandLord;

public interface UserServiceLandLord {
    UserDTOLandLord addUser(UserDTOLandLord userDTO);
    UserDTOLandLord getUser(long id);
    UserDTOLandLord updateUser(UserDTOLandLord userDTO, long id);
}
