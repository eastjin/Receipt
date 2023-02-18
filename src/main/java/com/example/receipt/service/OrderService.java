package com.example.receipt.service;

import com.example.receipt.dto.OrdersRequestDto;
import com.example.receipt.entity.Menu;
import com.example.receipt.entity.Orders;
import com.example.receipt.dto.MenuRequestDto;
import com.example.receipt.repository.MenuRepository;
import com.example.receipt.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final MenuRepository menuRepository;
//
//    @Transactional
//    public Orders createOrder(OrdersRequestDto requestDto) {
////        this.price = requestDto.getPrice();
////        this.orderTime = LocalDateTime.now();
//        Orders orders = new Orders(requestDto);
//        Menu menu = menuRepository.findById(requestDto.getMenuId()).orElseThrow(IllegalArgumentException::new);
//
//        // price,orderTime+menu;
//        orders.orderUpdate(menu);
//        ordersRepository.save(orders);
//        return orders;
//    }
}
