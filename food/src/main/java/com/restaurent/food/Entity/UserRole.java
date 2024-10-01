package com.restaurent.food.Entity;

import com.restaurent.food.Model.RoleEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
