package com.fstack.phong_tro_fstack.client.service;

import com.fstack.phong_tro_fstack.client.output.post.PagedPostResponse;
import com.fstack.phong_tro_fstack.client.output.post.PostResponse;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  PagedPostResponse getAllByNumberDateOtherZeroOrderByCreatedAt(
      Optional<String> idProvince,
      Optional<String> idDistrict,
      Optional<String> idWard,
      Optional<String> rentPrice,
      Optional<Float> minPrice,
      Optional<Float> maxPrice,
      Optional<String> acreage,
      Optional<Float> minAcreage,
      Optional<Float> maxAcreage,
      Optional<String> exactAddress,
      Optional<Integer> pageNumber,
      Optional<Integer> pageSize
  );

  PostResponse getDetailPost(Long id);

  PagedPostResponse getAllNumberDateOtherZeroAndStatusActive(
      Optional<String> idProvince,
      Optional<String> idDistrict,
      Optional<String> idWard,
      Optional<String> rentPrice,
      Optional<Float> minPrice,
      Optional<Float> maxPrice,
      Optional<String> acreage,
      Optional<Float> minAcreage,
      Optional<Float> maxAcreage,
      Optional<String> exactAddress,
      Optional<Integer> pageNumber,
      Optional<Integer> pageSize
  );

  PostResponse getDetailPostNumberDateOtherZeroAndStatusActive(Long id);
}