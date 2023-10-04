package com.example.kiosk.dto.Menu;

import com.example.kiosk.domain.Menu;
import lombok.Data;

@Data
public class MenuReqDto {
    private String menuName;
    private String menuImageUrl;
    private String menuMemo;
    private int menuPrice;

    public Menu toEntity(){
        return Menu.builder()
                .menuName(menuName)
                .menuImageUrl(menuImageUrl)
                .menuMemo(menuMemo)
                .menuPrice(menuPrice)
                .build();
    }
}
