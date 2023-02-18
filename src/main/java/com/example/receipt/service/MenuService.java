package com.example.receipt.service;

import com.example.receipt.dto.MenuRequestDto;
import com.example.receipt.entity.Menu;
import com.example.receipt.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu createMenu(MenuRequestDto requestDto){
        Menu menu = new Menu(requestDto);
        menuRepository.save(menu);
        return menu;
    }

    public List<Menu> getMenuAll(){
        return menuRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public Long update(Long id, MenuRequestDto requestDto){
        //더티체킹 활용한 부분. set을 통하여 save() 해도 되긴 하는데 동작 방식이 다르다.
        checkId(id).update(requestDto);
        return checkId(id).getId();
    }

    public Menu checkId(long id){
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return menu;
    }

    public String delete(Long id, MenuRequestDto requestDto) {
        checkId(id);
        menuRepository.deleteById(id);
        return "성공";
    }
}
