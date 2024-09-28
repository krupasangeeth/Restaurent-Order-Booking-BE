package com.restaurent.food.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuItemDto {
    
    private long menuItemId;

    private int price;

    private String category;

    private String name;
}
