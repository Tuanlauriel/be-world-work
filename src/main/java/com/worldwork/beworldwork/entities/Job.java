package com.worldwork.beworldwork.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jobs")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "offer", columnDefinition = "TEXT")
    private String offer;

    @Column(name = "requirement", columnDefinition = "TEXT")
    private String requirement;

    @Column(name = "create_at", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate createdAt;

    @Column(name = "from_salary")
    private Integer fromSalary;

    @Column(name = "to_salary")
    private Integer toSalary;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private JobField jobField;
}
