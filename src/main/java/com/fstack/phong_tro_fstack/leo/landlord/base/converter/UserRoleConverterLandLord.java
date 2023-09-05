package com.fstack.phong_tro_fstack.leo.landlord.base.converter;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.UserRoleDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.UserRoleEntityLandLord;
import org.springframework.stereotype.Component;

@Component
public class UserRoleConverterLandLord {
    public UserRoleEntityLandLord toEntity(UserRoleDTOLandLord userRoleDTO) {
        Long idUser= userRoleDTO.getUserId();
        Long idRole= userRoleDTO.getRoleId();
        UserRoleEntityLandLord userRoleKey= new UserRoleEntityLandLord();
        userRoleKey.setIdUser(idUser);
        userRoleKey.setIdRole(idRole);
        userRoleKey.setCreatedAt(userRoleDTO.getCreatedAt());
        return userRoleKey;
    }

    public UserRoleDTOLandLord toDTO(UserRoleEntityLandLord userRoleEntity) {
        Long idUser=userRoleEntity.getIdUser();
        Long idRole=userRoleEntity.getIdRole();
        UserRoleDTOLandLord userRoleKeyDTO=new UserRoleDTOLandLord();
        userRoleKeyDTO.setUserId(idUser);
        userRoleKeyDTO.setRoleId(idRole);
        userRoleKeyDTO.setCreatedAt(userRoleEntity.getCreatedAt());
        return userRoleKeyDTO;
    }
}
