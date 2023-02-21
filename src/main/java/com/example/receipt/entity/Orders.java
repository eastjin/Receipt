package com.example.receipt.entity;

import com.example.receipt.dto.MenuRequestDto;
import com.example.receipt.dto.OrdersRequestDto;
import com.example.receipt.repository.MenuRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Orders extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;


    public Orders(OrdersRequestDto requestDto, MenuRepository menuRepository){
        this.comment=requestDto.getComment();
        Long menuId = requestDto.getMenu_id();
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("메뉴 아이디를 확인해주세요."));
        this.menu=menu;

    }

}


