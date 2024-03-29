package com.example.receipt.service;

import com.example.receipt.dto.ErrorResponseDto;
import com.example.receipt.dto.MenuRequestDto;
import com.example.receipt.dto.MenuResponseDto;
import com.example.receipt.entity.Menu;
import com.example.receipt.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public ResponseEntity<?> createMenu(MenuRequestDto requestDto) {
        Menu menu = new Menu(requestDto);
        menuRepository.save(menu);

        // 메뉴와 해당 메뉴에 대한 가격을 매핑한 Map을 만듭니다.
        Map<String, Integer> menuPriceMap = new HashMap<>();
        menuPriceMap.put("chicken", 20000);
        menuPriceMap.put("pizza", 25000);

        Integer expectedPrice = menuPriceMap.get(menu.getName());
        if (expectedPrice != null && !expectedPrice.equals(menu.getPrice())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponseDto(false, "틀린 가격이 접수되었습니다."));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MenuResponseDto(true, menu.getName()));
    }


    public List<Menu> getMenuAll(){
        return menuRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public Long update(Long id, MenuRequestDto requestDto){
        //더티체킹 활용한 부분. set을 통하여 save() 해도 되긴 하는데 동작 방식이 다르다.
        //Service 메소드에서 Menu 타입의 checkId라는 메소드를 불러와
        // Menu 타입의 update 메소드를 가져오는 부분이다.
        checkId(id).update(requestDto);
        return checkId(id).getId();
    }

    public Menu checkId(long id){
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return menu;
    }

    public String delete(Long id) {
        checkId(id);
        menuRepository.deleteById(id);
        return "성공";
    }
}
