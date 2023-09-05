package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.UserEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryLandLord extends JpaRepository<UserEntityLandLord, Long> {
    UserEntityLandLord findOneById(Long id);
    @Query("select u from UserEntityLandLord u where u.email=:email and u.password=:pass")
    UserEntityLandLord login(@Param("email")String email, @Param("pass")String pass);
}
