package com.restaurent.food.Entity;

import com.restaurent.food.Model.OrderStatusEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
@Builder
@AllArgsConstructor
public class OrderItem {

    OrderItem(){

    }

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "order_id")
    // private Order order;

    @ManyToOne()
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    
}
