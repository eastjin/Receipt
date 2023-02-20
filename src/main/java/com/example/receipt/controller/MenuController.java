package com.example.receipt.controller;

import com.example.receipt.dto.ErrorResponseDto;
import com.example.receipt.dto.MenuRequestDto;
import com.example.receipt.dto.MenuResponseDto;
import com.example.receipt.entity.Menu;
import com.example.receipt.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
//    @PostMapping("/menu/elmnt")
//    public Menu createMenu(@RequestBody MenuRequestDto requestDto) {
//        //Board Entity에 requestdto 안의 값들을 받아서 createBoard 작업을 한다.
//        Menu menu_post = menuService.createMenu(requestDto);
//        return menu_post;
//    }
@PostMapping("/menu/elmnt")
public ResponseEntity<?> createMenu(@RequestBody MenuRequestDto requestDto) {
    // 메뉴 생성
    ResponseEntity<?>  menu_post = menuService.createMenu(requestDto);
    return menu_post;
}


    @GetMapping("/menu/elmnt")
    public List<Menu> getMenu() {
        List<Menu> menu_getAll =menuService.getMenuAll();
        return menu_getAll;
    }

    @PutMapping("/menu/elmnt/update/{id}")
    public Long updateMenu(@PathVariable Long id, @RequestBody MenuRequestDto requestDto) {
        return menuService.update(id, requestDto);
    }

    @DeleteMapping("/menu/elmnt/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        return menuService.delete(id);
    }
}
