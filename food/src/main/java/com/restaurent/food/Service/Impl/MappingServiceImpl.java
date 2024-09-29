package com.restaurent.food.Service.Impl;

import java.util.List;

import org.apache.catalina.Role;
import org.springframework.stereotype.Service;

import com.restaurent.food.DTO.MenuItemDto;
import com.restaurent.food.DTO.OrderDto;
import com.restaurent.food.DTO.OrderItemDto;
import com.restaurent.food.DTO.UserDto;
import com.restaurent.food.DTO.UserRoleDto;
import com.restaurent.food.Entity.MenuItem;
import com.restaurent.food.Entity.Order;
import com.restaurent.food.Entity.OrderItem;
import com.restaurent.food.Entity.User;
import com.restaurent.food.Entity.UserRole;
import com.restaurent.food.Service.MappingService;


@Service
public class MappingServiceImpl implements MappingService {

    @Override
    public Order convertToOrderEntity(OrderDto orderDto) {
        // TODO Auto-generated method stub
        return Order.builder()
        .orderId(orderDto.getOrderId())
        .orderItems(convertToOrderItemEntity(orderDto.getOrderItemsDto()))
        .user(convertToUserEntity(orderDto.getUserDto()))
        .totalAmount(orderDto.getTotalAmount())
        .build();
    }

    public List<OrderItem> convertToOrderItemEntity (List<OrderItemDto> orderItemsDto){
         return orderItemsDto.stream()
        .map((orderItemDto) -> OrderItem.builder()
        .orderItemId(orderItemDto.getOrderItemId())
        .quantity(orderItemDto.getQuantity())
        .menuItem(convertToMenuItemEntity(orderItemDto.getMenuItemDto()))
        .build())
        .toList();
    }
    
    public MenuItem convertToMenuItemEntity(MenuItemDto menuItemDto) {
        return MenuItem.builder()
        .name(menuItemDto.getName())
        .menuItemId(menuItemDto.getMenuItemId())
        .price(menuItemDto.getPrice())
        .category(menuItemDto.getCategory())
        .build();
    }

    public User convertToUserEntity(UserDto userDto){
        
    return User.builder()
    .userId(userDto.getUserId())
    .mobile(userDto.getMobile())
    .role(converttoRoleEntity(userDto.getUserRoleDto()))
    .build();

    }

    public UserRole converttoRoleEntity(UserRoleDto userRoleDto){
         UserRole userRole = new UserRole();
         userRole.setRole(userRoleDto.getRole());
         userRole.setRoleId(userRoleDto.getRoleId());

         return userRole;
    }

    public UserRoleDto converttoRoleDto(UserRole userRole){

        return UserRoleDto.builder()
        .role(userRole.getRole())
        .roleId(userRole.getRoleId())
        .build();

   }

    public UserDto convertToUserDto(User user) {
        return UserDto.builder()
        .userId(user.getUserId())
        .mobile(user.getMobile())
        .userRoleDto(converttoRoleDto(user.getRole()))
        .build();
    }

}
