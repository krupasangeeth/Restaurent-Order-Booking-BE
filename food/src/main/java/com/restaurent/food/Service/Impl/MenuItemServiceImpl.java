package com.restaurent.food.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurent.food.DTO.MenuItemDto;
import com.restaurent.food.Entity.MenuItem;
import com.restaurent.food.Repository.MenuItemRepository;
import com.restaurent.food.Service.MenuItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService{

    private final MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItemDto> getMenuItems() {
        // TODO Auto-generated method stub
        List<MenuItem> menuItems = menuItemRepository.findAll();

        return menuItems.stream()
        // .map((i) -> this.convertToMenuItemDto(i))
        .map(this::convertToMenuItemDto)
        .toList();
    }

    private MenuItemDto convertToMenuItemDto(MenuItem menuItem) {

        return MenuItemDto.builder()
        .name(menuItem.getName())
        .menuItemId(menuItem.getMenuItemId())
        .price(menuItem.getPrice())
        .category(menuItem.getCategory())
        .build();

    }
    
}
