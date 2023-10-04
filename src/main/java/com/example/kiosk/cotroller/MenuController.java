package com.example.kiosk.cotroller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.dto.Menu.MenuReqDto;
import com.example.kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    //==================
    //메뉴 정보 올리기
    //메뉴 정보 삭제하기
    //메뉴 정보 수정하기
    //메뉴 사진 올리기?
    //==================


    //메뉴 정보 올리기
  //  @PostMapping("/menu")
  //  public void menuUpdate(MemuReqDto memuReqDto){
//        menuService.메뉴정보올리기(memuReqDto.toEntity());
//    }
//    @PostMapping("/menu")
//    public ResponseEntity<String> menuUpdate(@RequestBody MemuReqDto memuReqDto) {
//        menuService.메뉴정보올리기(memuReqDto.toEntity());
//        return ResponseEntity.ok("메뉴 정보가 성공적으로 등록되었습니다.");
//    }

        @PostMapping("/create")
        public ResponseEntity<Menu> createMenu(@RequestBody MenuReqDto menuReqDto) {
            String menuName = menuReqDto.getMenuName();
            String menuImageUrl = menuReqDto.getMenuImageUrl();
            String menuMemo = menuReqDto.getMenuMemo();
            int menuPrice = menuReqDto.getMenuPrice();

            // Menu 엔티티 객체 생성
            Menu menu = Menu.builder()
                    .menuName(menuName)
                    .menuImageUrl(menuImageUrl)
                    .menuMemo(menuMemo)ㅎㅎㅎ
                    .menuPrice(menuPrice)
                    .build();

            // 메뉴 저장
            Menu savedMenu = menuService.저장(menu);
            return ResponseEntity.ok(savedMenu);
        }


//        @PostMapping("/create")
//        public ResponseEntity<Menu> createMenu(@RequestBody MenuReqDto menuReqDto) {
//            Menu menu = menuReqDto.toEntity();
//            Menu savedMenu = menuService.저장(menu);
//            return ResponseEntity.ok(savedMenu);
//        }

        @GetMapping("/{menuId}")
        public ResponseEntity<Menu> getMenu(@PathVariable int menuId) {
            Menu menu = menuService.조회(menuId);
            if (menu != null) {
                return ResponseEntity.ok(menu);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/all")
        public ResponseEntity<List<Menu>> getAllMenus() {
            List<Menu> menus = menuService.모든메뉴조회();
            return ResponseEntity.ok(menus);
        }

        @DeleteMapping("/{menuId}")
        public ResponseEntity<Void> deleteMenu(@PathVariable int menuId) {
            menuService.삭제(menuId);
            return ResponseEntity.noContent().build();
        }
    }



