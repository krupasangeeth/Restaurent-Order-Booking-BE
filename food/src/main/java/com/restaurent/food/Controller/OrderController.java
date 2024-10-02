package com.restaurent.food.Controller;

import com.restaurent.food.Model.ResponseBody;
import com.restaurent.food.Model.RoleEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurent.food.DTO.OrderDto;
import com.restaurent.food.Service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/order")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto, @RequestHeader("mobile") Long mobile){
        orderService.saveOrder(orderDto,mobile);
        return ResponseEntity.ok().body(new ResponseBody("Order Saved"));
    }  
    
    @GetMapping(value = "/order")
    public ResponseEntity<List<OrderDto>> getOrders(){
        List<OrderDto> orders = orderService.getOrders();

        return ResponseEntity.ok().body(orders);
    }
    
}
