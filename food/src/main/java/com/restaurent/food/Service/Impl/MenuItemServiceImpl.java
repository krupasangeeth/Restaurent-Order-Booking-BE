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

    private final MappingServiceImpl mappingService;

    @Override
    public List<MenuItemDto> getMenuItems() {

        List<MenuItem> menuItems = menuItemRepository.findAll();

        return menuItems.stream()
        // .map((i) -> this.convertToMenuItemDto(i))
        .map(this::convertToMenuItemDto)
        .toList();
    }

    @Override
    public void addMenuItems(List<MenuItemDto> menuItemsDto) {

        List<MenuItem> menuItems = menuItemsDto.stream().map(mappingService::convertToMenuItemEntity).toList();

        menuItemRepository.saveAll(menuItems);

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
