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

    @Transactional
    public Orders createOrder(OrdersRequestDto requestDto) {
        Orders orders = new Orders(requestDto, menuRepository);
        ordersRepository.save(orders);
        return orders;

    }
}
