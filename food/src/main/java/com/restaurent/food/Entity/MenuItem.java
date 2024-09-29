package com.restaurent.food.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "menu_item_id")
    private long menuItemId;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

}
