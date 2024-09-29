package com.restaurent.food.Entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "_order")
@Data
@Builder
@AllArgsConstructor
public class Order {

    Order(){

    }

    @Id
    @Column(name = "order_id")
    private long orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_order_item",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name ="order_item_id")
    )
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private int totalAmount;
}
