package com.itqgroup.service.impl;

import com.itqgroup.dto.DetailDto;
import com.itqgroup.exception.DataNotFoundException;
import com.itqgroup.mapper.DetailMapper;
import com.itqgroup.mapper.OrderMapper;
import com.itqgroup.model.Detail;
import com.itqgroup.model.Order;
import com.itqgroup.repository.DetailRepository;
import com.itqgroup.repository.OrderRepository;
import com.itqgroup.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<DetailDto> findAllDetails(Integer from, Integer to) {
        Pageable page = PageRequest.of(from / to, to);
        List<Detail> details = detailRepository.findAllWithOrders(page);
        // собираем заказы по id detail
        Map<Long, Order> orders = details.stream()
                .collect(Collectors.toMap(Detail::getId, Detail::getOrder));
        // маппим детали в DetailDto передавая Order по id детали в OrderMapper, чтобы смаппить в OrderDto
        return details.stream()
                .map(detail -> DetailMapper.mapToDto(detail, OrderMapper.mapToDto(orders.get(detail.getId()))))
                .collect(Collectors.toList());
    }

    @Override
    public DetailDto findDetailById(Long detailId) {
        Detail detail = detailRepository.findByIdWithOrder(detailId).orElseThrow(() ->
                new DataNotFoundException(String.format("Order detail by id=%d is not in the database", detailId)));
        return DetailMapper.mapToDto(detail, OrderMapper.mapToDto(detail.getOrder()));
    }

    @Override
    public DetailDto addDetail(DetailDto dto) {
        Detail detail = DetailMapper.mapToOrder(dto);
        Long orderId = dto.getOrder().getId();
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new DataNotFoundException(String.format("Order by id=%d is not in the database", orderId)));
        detail.setOrder(order);
        return DetailMapper.mapToDto(detailRepository.save(detail), OrderMapper.mapToDto(order));
    }
}
