package com.restaurent.food.DTO;

import com.restaurent.food.Model.RoleEnum;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRoleDto {

    private long roleId;

    private RoleEnum role;
    
}
