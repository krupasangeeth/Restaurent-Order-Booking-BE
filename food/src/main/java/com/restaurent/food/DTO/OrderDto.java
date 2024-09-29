package com.restaurent.food.DTO;



import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class OrderDto {

    private long orderId;

    private UserDto userDto;

    private List<OrderItemDto> orderItemsDto;
    
    private int totalAmount;

}
