package com.restaurent.food.Service;

import java.util.List;

import com.restaurent.food.DTO.OrderDto;


public interface OrderService {
    List<OrderDto> getOrder();
    void saveOrder(OrderDto orderDto);
}
