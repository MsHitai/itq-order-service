package com.itqgroup.service;

import com.itqgroup.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders(Integer from, Integer to);

    OrderDto findOrderById(Long orderId);

    OrderDto addOrder(OrderDto dto);
}
