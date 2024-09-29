package com.restaurent.food.Repository;

import com.restaurent.food.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByMobile(long mobile);
}
