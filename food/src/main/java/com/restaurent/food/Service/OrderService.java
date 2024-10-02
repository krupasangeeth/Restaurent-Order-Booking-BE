package com.restaurent.food.Service;

import java.util.List;

import com.restaurent.food.DTO.OrderDto;


public interface OrderService {
    List<OrderDto> getOrders();
    void saveOrder(OrderDto orderDto,Long mobile);
}
