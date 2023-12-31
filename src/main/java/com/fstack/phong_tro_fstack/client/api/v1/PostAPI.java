package com.fstack.phong_tro_fstack.client.api.v1;

import com.fstack.phong_tro_fstack.client.output.post.PagedPostResponse;
import com.fstack.phong_tro_fstack.client.service.PostService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest/post")
public class PostAPI {

  @Autowired
  private PostService postService;

  @GetMapping()
  public ResponseEntity<?> findAllNumberDateOtherZeroOrderByCreatedAt(
      @Param("idProvince") Optional<String> idProvince,
      @Param("idDistrict") Optional<String> idDistrict,
      @Param("idWard") Optional<String> idWard,
      @Param("rentPrice") Optional<String> rentPrice,
      @Param("minPrice") Optional<Float> minPrice,
      @Param("maxPrice") Optional<Float> maxPrice,
      @Param("acreage") Optional<String> acreage,
      @Param("minAcreage") Optional<Float> minAcreage,
      @Param("maxAcreage") Optional<Float> maxAcreage,
      @Param("exactAddress") Optional<String> exactAddress,
      @Param(value = "pageNumber") Optional<Integer> pageNumber,
      @Param(value = "pageSize") Optional<Integer> pageSize
  ) {
    PagedPostResponse result = postService.getAllByNumberDateOtherZeroOrderByCreatedAt(
        idProvince,
        idDistrict,
        idWard,
        rentPrice,
        minPrice,
        maxPrice,
        acreage,
        minAcreage,
        maxAcreage,
        exactAddress,
        pageNumber,
        pageSize
    );
    return ResponseEntity.ok(result);
  }

  @GetMapping("/search")
  public ResponseEntity<?> findAllNumberDateOtherZeroAndStatusActive(
      @Param("idProvince") Optional<String> idProvince,
      @Param("idDistrict") Optional<String> idDistrict,
      @Param("idWard") Optional<String> idWard,
      @Param("rentPrice") Optional<String> rentPrice,
      @Param("minPrice") Optional<Float> minPrice,
      @Param("maxPrice") Optional<Float> maxPrice,
      @Param("acreage") Optional<String> acreage,
      @Param("minAcreage") Optional<Float> minAcreage,
      @Param("maxAcreage") Optional<Float> maxAcreage,
      @Param("exactAddress") Optional<String> exactAddress,
      @Param(value = "pageNumber") Optional<Integer> pageNumber,
      @Param(value = "pageSize") Optional<Integer> pageSize
  ) {
    PagedPostResponse result = postService.getAllNumberDateOtherZeroAndStatusActive(
        idProvince,
        idDistrict,
        idWard,
        rentPrice,
        minPrice,
        maxPrice,
        acreage,
        minAcreage,
        maxAcreage,
        exactAddress,
        pageNumber,
        pageSize
    );
    return ResponseEntity.ok(result);
  }
}