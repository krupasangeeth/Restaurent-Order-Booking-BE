package com.restaurent.food.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.food.DTO.OrderDto;
import com.restaurent.food.Service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/order")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return ResponseEntity.ok().body("Order Saved");
    }  
    
}
