package com.itqgroup.service.impl;

import com.itqgroup.client.BusinessClient;
import com.itqgroup.dto.OrderDto;
import com.itqgroup.dto.TimeDto;
import com.itqgroup.exception.DataNotFoundException;
import com.itqgroup.mapper.OrderMapper;
import com.itqgroup.model.Order;
import com.itqgroup.repository.DetailRepository;
import com.itqgroup.repository.OrderRepository;
import com.itqgroup.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final OrderRepository orderRepository;
    private final BusinessClient client;
    private final DetailRepository detailRepository;

    @Override
    public List<OrderDto> findAllOrders(Integer from, Integer to) {
        Pageable page = PageRequest.of(from / to, to);
        return orderRepository.findAll(page).stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new DataNotFoundException(String.format("Order by id=%d is not in the database", orderId)));
        return OrderMapper.mapToDto(order);
    }

    @Override
    public OrderDto addOrder(OrderDto dto) {
        TimeDto time = client.findTime();
        dto.setCreated(time.getTime());
        Order order = OrderMapper.mapToOrder(dto);
        return OrderMapper.mapToDto(orderRepository.save(order));
    }
}
