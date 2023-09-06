package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.RoleEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoryLandLord extends JpaRepository<RoleEntityLandLord, Long> {
    RoleEntityLandLord findOneById(Long id);
}
