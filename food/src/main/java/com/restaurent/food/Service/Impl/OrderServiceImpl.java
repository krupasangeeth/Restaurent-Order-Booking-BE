package com.restaurent.food.Service.Impl;

import java.util.List;

import com.restaurent.food.Entity.User;
import com.restaurent.food.Model.RoleEnum;
import com.restaurent.food.Repository.UserRepository;
import com.restaurent.food.Repository.UserRoleRepository;
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
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;


    @Override
    public List<OrderDto> getOrders() {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(this::convertToOrderDto).toList();

    }

    private OrderDto convertToOrderDto(Order order){

        List<OrderItemDto> orderItemsDto = order.getOrderItems().stream()
        .map((orderItem) -> OrderItemDto.builder()
        .orderItemId(orderItem.getOrderItemId())
        .quantity(orderItem.getQuantity())
        .status(orderItem.getStatus())
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
    public void saveOrder(OrderDto orderDto, Long mobile) {
        // TODO Auto-generated method stub

//        orderDto.getUserDto().setUserRoleDto(
//                userRoleRepository.findByRole(RoleEnum.USER)
//        );
        User user = userRepository.findByMobile(mobile);
        Order order = mappingService.convertToOrderEntity(orderDto);
        order.setUser(user);

        orderRepository.save(order);

    };
    
    
}
