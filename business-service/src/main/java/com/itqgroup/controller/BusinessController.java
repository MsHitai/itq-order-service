package com.itqgroup.controller;

import com.itqgroup.dto.OrderDto;
import com.itqgroup.service.BusinessService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * Method finds all orders
     *
     * @param from offset
     * @param to   limit
     * @return a list of orders
     */
    @GetMapping
    public List<OrderDto> findAllOrders(@PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                        @Positive @RequestParam(defaultValue = "10") Integer to) {
        log.info("Received GET request to fetch all orders from {} offset to {} limit", from, to);
        return businessService.findAllOrders(from, to);
    }

    /**
     * Method find an order by its identification
     *
     * @param orderId identification of an order
     * @return the order
     */
    @GetMapping("/{orderId}")
    public OrderDto findOrderById(@PathVariable(name = "orderId") Long orderId) {
        log.info("Received GET request to find order by id {}", orderId);
        return businessService.findOrderById(orderId);
    }

    /**
     * Method creates a new order
     *
     * @param dto OrderDto in json format
     * @return the created order
     */
    @PostMapping
    public OrderDto addOrder(@Valid @RequestBody OrderDto dto) {
        log.info("Received POST request to add an order {}", dto.toString());
        return businessService.addOrder(dto
        );
    }
}
