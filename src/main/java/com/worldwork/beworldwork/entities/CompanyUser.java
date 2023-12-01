package com.worldwork.beworldwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_user_id")
    private Long companyUserId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
