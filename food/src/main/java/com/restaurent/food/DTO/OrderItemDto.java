package com.restaurent.food.DTO;

import com.restaurent.food.Entity.Order;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItemDto {
  
    private long orderItemId;

    private Order order;

    private MenuItemDto menuItemDto;

    private int quantity;

}
