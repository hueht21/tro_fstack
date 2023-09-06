package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.AreaEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepositoryLandLord extends JpaRepository<AreaEntityLandLord, Long> {

  @Query(value = "select a from AreaEntityLandLord a inner join PostEntityLandLord p on a.id=p.areaId where p.id=:idPost")
  AreaEntityLandLord getAreaByPostId(@Param("idPost") Long id);
}
