package com.worldwork.beworldwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_fields")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;
}
