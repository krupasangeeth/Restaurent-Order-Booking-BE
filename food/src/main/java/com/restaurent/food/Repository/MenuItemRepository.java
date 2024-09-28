package com.restaurent.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.food.Entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
    
}
