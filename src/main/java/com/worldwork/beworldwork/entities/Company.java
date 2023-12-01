package com.worldwork.beworldwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;

    private String name;

    private String logo;

    private String address;

    private String website;

    private String email;

    private String phone;

    private boolean status;

    private String description;

    private String banner;

    private String businessLicense;
}
