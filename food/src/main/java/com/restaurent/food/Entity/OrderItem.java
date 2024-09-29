package com.restaurent.food.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private long orderItemId;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "order_id")
    // private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @Column(name = "quantity")
    private int quantity;
    
}
