package com.restaurent.food.Controller;

import java.util.List;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.restaurent.food.Model.ResponseBody;
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
    @PostMapping(value = "/menuitem")
    public ResponseEntity<ResponseBody> updateMenuItem(@RequestBody MenuItemDto menuItemDto){

        menuItemService.updateMenuItem(menuItemDto);

        return ResponseEntity.ok(new ResponseBody("Updated menu item successfully"));
    }

    @DeleteMapping(value = "/menuitem")
    public ResponseEntity<ResponseBody> deleteMenuItem(@RequestBody MenuItemDto menuItemDto){

        menuItemService.deleteMenuItem(menuItemDto);

        return ResponseEntity.ok(new ResponseBody("Deleted"));
    }

}
