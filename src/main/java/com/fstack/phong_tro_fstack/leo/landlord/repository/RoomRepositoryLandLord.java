package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.RoomEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepositoryLandLord extends JpaRepository<RoomEntityLandLord, Long> {

  @Query(value = "select r from RoomEntityLandLord  r inner join AreaEntityLandLord a on a.id=r.areaId where r.areaId=:idArea")
  List<RoomEntityLandLord> getRoombyAreaId(@Param("idArea") long idArea);

  @Query(value = "select r from RoomEntityLandLord r inner join AreaEntityLandLord a on a.id=r.areaId"
      + "      inner join PostEntityLandLord p on a.id=p.areaId  where p.id=:idPost")
  List<RoomEntityLandLord> getRoombyPostId(@Param("idPost") long idPost);

}
