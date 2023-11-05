package com.itqgroup.service;

import com.itqgroup.dto.DetailDto;

import java.util.List;

public interface DetailService {
    List<DetailDto> findAllDetails(Integer from, Integer to);

    DetailDto findDetailById(Long detailId);

    DetailDto addDetail(DetailDto dto);
}
