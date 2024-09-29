package com.restaurent.food.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurent.food.DTO.MenuItemDto;
import com.restaurent.food.DTO.OrderDto;
import com.restaurent.food.DTO.OrderItemDto;
import com.restaurent.food.Entity.MenuItem;
import com.restaurent.food.Entity.Order;
import com.restaurent.food.Repository.OrderRepository;
import com.restaurent.food.Service.MappingService;
import com.restaurent.food.Service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MappingServiceImpl mappingService;


    @Override
    public List<OrderDto> getOrder() {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(this::convertToOrderDto).toList();

    }

    private OrderDto convertToOrderDto(Order order){

        List<OrderItemDto> orderItemsDto = order.getOrderItems().stream()
        .map((orderItem) -> OrderItemDto.builder()
        .orderItemId(orderItem.getOrderItemId())
        .quantity(orderItem.getQuantity())
        .menuItemDto(convertToMenuItemDto(orderItem.getMenuItem()))
        .build())
        .toList();


        return OrderDto.builder()
        .orderId(order.getOrderId())
        .orderItemsDto(orderItemsDto)
        .userDto(mappingService.convertToUserDto(order.getUser()))
        .totalAmount(order.getTotalAmount())
        .build();
    }

    private MenuItemDto convertToMenuItemDto(MenuItem menuItem) {
        return MenuItemDto.builder()
        .name(menuItem.getName())
        .menuItemId(menuItem.getMenuItemId())
        .price(menuItem.getPrice())
        .category(menuItem.getCategory())
        .build();
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        // TODO Auto-generated method stub

        orderRepository.save(mappingService.convertToOrderEntity(orderDto));

    };
    
    
}
