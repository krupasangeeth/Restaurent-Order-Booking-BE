package com.restaurent.food.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.food.DTO.MenuItemDto;
import com.restaurent.food.Service.MenuItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping(value = "/menuitems")
    public List<MenuItemDto> getMenuItems() {
        return menuItemService.getMenuItems();
    }
    
}
