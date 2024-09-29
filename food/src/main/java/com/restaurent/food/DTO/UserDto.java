package com.restaurent.food.DTO;


import com.restaurent.food.Entity.Order;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserDto {
    
    private long userId;

    private long mobile;

    private UserRoleDto userRoleDto;

    private List<Order> orders;

}
