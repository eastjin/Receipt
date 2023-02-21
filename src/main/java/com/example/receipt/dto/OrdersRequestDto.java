package com.example.receipt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersRequestDto {
    private Long menu_id;
    private String comment;
}
