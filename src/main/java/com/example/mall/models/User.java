package com.example.mall.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private Role role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
