package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name = "userstest")
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false)
    private String role;
}