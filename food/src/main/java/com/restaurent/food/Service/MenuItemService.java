package com.restaurent.food.Service;

import java.util.List;

import com.restaurent.food.DTO.MenuItemDto;

public interface MenuItemService {

    List<MenuItemDto> getMenuItems();

    void addMenuItems(List<MenuItemDto> menuItemsDto);
    void updateMenuItem(MenuItemDto menuItemsDto);
    void deleteMenuItem(MenuItemDto menuItemsDto);

}
