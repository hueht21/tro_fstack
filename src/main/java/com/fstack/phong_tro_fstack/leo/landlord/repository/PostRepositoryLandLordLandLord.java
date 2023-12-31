package com.fstack.phong_tro_fstack.leo.landlord.repository;

import com.fstack.phong_tro_fstack.leo.landlord.base.entity.PostEntityLandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryLandLordLandLord extends JpaRepository<PostEntityLandLord, Long> {

  @Query("Select p from PostEntityLandLord p where p.numberDate <> 0 order by p.createdAt desc")
  List<PostEntityLandLord> findAllNumberDateOtherZeroOrderByCreatedAt();
// truy vấn nối bảng post vs area left join với rate
//  @Query("SELECT r.ratingStarts, p.content, p.status, p.title, p.thumbnail "
//      + "FROM PostEntity p "
//      + "INNER JOIN AreaEntity a ON a.id = p.areaEntity.id "
//      + "LEFT JOIN RateEntity r ON r.areaEntity.id = a.id "
//      + "WHERE p.userEntity.id = :idUser")


  @Query(
      "SELECT p.content, p.status, p.title, p.thumbnail,p.id, CAST(AVG(r.ratingStarts) AS FLOAT) " +
          " FROM PostEntityLandLord p " +
          " INNER JOIN AreaEntityLandLord a on p.areaId=a.id" +
          " LEFT JOIN RateEntityLandLord r on r.areaId=a.id "  +
          " WHERE p.userId= :idUser AND p.status in (1,0)" +
          " GROUP BY p.id, p.content, p.status, p.title, p.thumbnail")
  List<Object[]> getPostandRatebyUser(@Param("idUser") long idUser);

  @Query("select p from  PostEntityLandLord p inner join AreaEntityLandLord a on p.areaId=a.id where a.id=:idArea")
  PostEntityLandLord getPostbyAreaId(@Param("idArea") long idArea);
}
