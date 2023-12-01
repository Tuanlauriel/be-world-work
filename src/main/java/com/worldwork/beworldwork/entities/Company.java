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
    @Column(name="company_id")
    private Integer company_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "banner")
    private String banner;

    @Column(name = "business_license", nullable = false)
    private String businessLicense;
}
