package com.restaurent.food.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "menu_item")
@Data
@Builder
@AllArgsConstructor
public class MenuItem {
    MenuItem(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_id")
    private long menuItemId;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

}
