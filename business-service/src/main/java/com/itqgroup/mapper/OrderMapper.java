package com.itqgroup.mapper;

import com.itqgroup.dto.OrderDto;
import com.itqgroup.model.Order;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderMapper {

    public OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .amount(order.getAmount())
                .clientName(order.getClientName())
                .created(order.getCreated())
                .build();
    }

    public Order mapToOrder(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .amount(dto.getAmount())
                .clientName(dto.getClientName())
                .created(dto.getCreated())
                .build();
    }
}
