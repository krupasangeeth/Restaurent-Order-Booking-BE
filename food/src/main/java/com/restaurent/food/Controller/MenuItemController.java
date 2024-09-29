package com.restaurent.food.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/menuitems")
    public ResponseEntity<String> addMenuItems(@RequestBody List<MenuItemDto> menuItemsDto){

        menuItemService.addMenuItems(menuItemsDto);

        return ResponseEntity.ok("Added menu items successfully");
    }
    
}
