package com.itqgroup.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    @NotNull
    private String clientName;
    @NotNull
    private String address;
    @NotNull
    private double amount;
    private LocalDateTime created;
}
