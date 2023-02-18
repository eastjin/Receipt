package com.example.receipt.entity;

import com.example.receipt.dto.MenuRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // 다대일 관계 설정
    @JoinColumn(name = "menu_id") // menu_id 컬럼을 참조
    private Menu menu;
    //메뉴 정보들이 다 들어감

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private LocalDateTime orderTime;

        public Orders(MenuRequestDto requestDto) {
        //this.menuId = menuId;
        this.price = requestDto.getPrice();
        this.orderTime = LocalDateTime.now();
    }

    public void orderUpdate(Menu menu){
        this.menu=menu;
    }

//    public Orders(OrdersRequestDto requestDto, Menu menu) {
//        this.menu = menu;
//        this.price = requestDto.getPrice();
//        this.orderTime = LocalDateTime.now();
//    }


}


