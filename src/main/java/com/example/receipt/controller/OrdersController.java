package com.example.receipt.controller;

import com.example.receipt.dto.OrdersRequestDto;
import com.example.receipt.entity.Orders;
import com.example.receipt.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @PostMapping("/orders/elmnt")
    public Orders createOrder(@RequestBody OrdersRequestDto requestDto) {
        //Board Entity에 requestdto 안의 값들을 받아서 createBoard 작업을 한다.
        Orders order_post = orderService.createOrder(requestDto);
        return order_post;
    }
}
