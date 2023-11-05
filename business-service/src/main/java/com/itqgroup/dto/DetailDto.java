package com.itqgroup.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailDto {

    private Long id;
    @NotNull
    private String serialNumber;
    @NotNull
    private String name;
    @NotNull
    private Long quantity;
    @NotNull
    private OrderDto order;
}


