package com.itqgroup.controller;

import com.itqgroup.dto.DetailDto;
import com.itqgroup.service.DetailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
@Slf4j
public class DetailController {

    private final DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    /**
     * Method finds all order details Pageable
     *
     * @param from offset
     * @param to   limit
     * @return a list of DetailDto
     */
    @GetMapping
    public List<DetailDto> findAllDetails(@PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                          @Positive @RequestParam(defaultValue = "10") Integer to) {
        log.info("Received GET request to fetch all order details from {} offset to {} limit", from, to);
        return detailService.findAllDetails(from, to);
    }

    /**
     * Method find an order detail by its identification
     *
     * @param detailId identification of an order
     * @return the order
     */
    @GetMapping("/{detailId}")
    public DetailDto findDetailById(@PathVariable(name = "detailId") Long detailId) {
        log.info("Received GET request to find order detail by id {}", detailId);
        return detailService.findDetailById(detailId);
    }

    /**
     * Method creates a new order detail
     *
     * @param dto DetailDto in json format
     * @return the created order
     */
    @PostMapping
    public DetailDto addDetail(@Valid @RequestBody DetailDto dto) {
        log.info("Received POST request to add an order detail {}", dto.toString());
        return detailService.addDetail(dto);
    }
}
