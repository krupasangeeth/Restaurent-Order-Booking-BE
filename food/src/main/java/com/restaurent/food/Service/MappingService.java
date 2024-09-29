package com.restaurent.food.Service;

import com.restaurent.food.DTO.OrderDto;
import com.restaurent.food.Entity.Order;

public interface MappingService {
    Order convertToOrderEntity(OrderDto orderDto);
}
