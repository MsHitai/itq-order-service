package com.itqgroup.mapper;

import com.itqgroup.dto.DetailDto;
import com.itqgroup.dto.OrderDto;
import com.itqgroup.model.Detail;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DetailMapper {

    public DetailDto mapToDto(Detail detail, OrderDto dto) {
        return DetailDto.builder()
                .id(detail.getId())
                .name(detail.getName())
                .serialNumber(detail.getSerialNumber())
                .quantity(detail.getQuantity())
                .order(dto)
                .build();
    }

    public Detail mapToOrder(DetailDto dto) {
        return Detail.builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .serialNumber(dto.getSerialNumber())
                .build();
    }
}
