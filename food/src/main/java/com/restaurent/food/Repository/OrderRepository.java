package com.restaurent.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.food.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
