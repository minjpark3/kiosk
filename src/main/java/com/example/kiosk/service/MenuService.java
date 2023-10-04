package com.example.kiosk.service;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
//    public void 메뉴정보올리기(Menu menu) {
//        menuRepository.save(menu);
//
//    }

    public Menu 저장(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu 조회(int menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }

    public List<Menu> 모든메뉴조회() {
        return menuRepository.findAll();
    }

    public void 삭제(int menuId) {
        menuRepository.deleteById(menuId);
    }
}