package com.restaurent.food.Repository;

import com.restaurent.food.Entity.UserRole;
import com.restaurent.food.Model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(RoleEnum role);
}
