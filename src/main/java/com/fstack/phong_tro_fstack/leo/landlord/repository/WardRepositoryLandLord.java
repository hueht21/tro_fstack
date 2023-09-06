package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.WardEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepositoryLandLord extends JpaRepository<WardEntityLandLord, Long> {

    WardEntityLandLord findByDistrictId(long districtId);
    List<WardEntityLandLord> findAllByDistrictId(long idDistrict);
}
