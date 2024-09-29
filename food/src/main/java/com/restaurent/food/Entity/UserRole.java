package com.restaurent.food.Entity;

import com.restaurent.food.Model.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    @Id
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
