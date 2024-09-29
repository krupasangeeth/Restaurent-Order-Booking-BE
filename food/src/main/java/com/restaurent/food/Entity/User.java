package com.restaurent.food.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
public class User {

    User(){}

    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "mobile")
    private long mobile;

    @JoinColumn(name = "role_id")
    @OneToOne
    private UserRole role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

}
