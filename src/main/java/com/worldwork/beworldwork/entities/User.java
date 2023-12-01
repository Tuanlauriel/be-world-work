package com.worldwork.beworldwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jobs")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;

    private String address;

    private String phone;
}
