package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.DistrictEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DistrictRepositoryLandLord extends JpaRepository<DistrictEntityLandLord, Long> {

    List<DistrictEntityLandLord> findAllByProvinceId(long provinceId);
}
