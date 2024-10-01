package com.restaurent.food.Entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_seq",allocationSize = 1, initialValue = 21000)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "mobile")
    private long mobile;

    @JoinColumn(name = "role_id")
    @ManyToOne
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
