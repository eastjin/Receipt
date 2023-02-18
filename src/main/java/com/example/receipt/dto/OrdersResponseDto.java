package com.example.receipt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class OrdersResponseDto {
    private boolean isSuccess;
    private String menu;
    private LocalDateTime orderTime;
    private String errorMessage;

    public OrdersResponseDto(boolean isSuccess, String menu, LocalDateTime orderTime, String errorMessage) {
        this.isSuccess = isSuccess;
        this.menu = menu;
        this.orderTime = orderTime;
        this.errorMessage = errorMessage;
    }
}

