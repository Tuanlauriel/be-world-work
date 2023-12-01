package com.worldwork.beworldwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_skills")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_skill_id")
    private Long jobSkillId;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;
}
