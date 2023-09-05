package com.fstack.phong_tro_fstack.leo.landlord.service.impl;


import com.fstack.phong_tro_fstack.leo.landlord.base.dto.UserDTOLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.UserEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.UserRepositoryLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.service.UserServiceLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImplementLandLord implements UserServiceLandLord {


    private final UserRepositoryLandLord userRepository;


    @Override
    public UserDTOLandLord addUser(UserDTOLandLord userDTO) {
        if (userDTO != null) {
            UserEntityLandLord user = new UserEntityLandLord();
            user.setCreatedAt(Date.valueOf(java.time.LocalDate.now()));
            user.setEmail(userDTO.getEmail());
            user.setFullName(userDTO.getFullName());
            user.setIdCard(userDTO.getIdCard());
            user.setPassword(userDTO.getPassword());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            userRepository.save(user);
        }
        return userDTO;
    }

    @Override
    public UserDTOLandLord getUser(long id) {

        UserEntityLandLord user = userRepository.findOneById(id);
        UserDTOLandLord userDTO = new UserDTOLandLord();
        userDTO.setId(user.getId());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFullName());
        userDTO.setIdCard(user.getIdCard());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    @Override
    public UserDTOLandLord updateUser(UserDTOLandLord userDTO, long id) {
        if(userDTO!=null && id!=0){
            UserEntityLandLord user = userRepository.findOneById(id);
        if(user!=null){
            userDTO.setId(user.getId());
            user.setCreatedAt(Date.valueOf(java.time.LocalDate.now()));
            user.setEmail(userDTO.getEmail());
            user.setFullName(userDTO.getFullName());
            user.setIdCard(userDTO.getIdCard());
            user.setPassword(userDTO.getPassword());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            userRepository.save(user);
        }
        }
        return userDTO;
    }

}
