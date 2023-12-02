package com.worldwork.beworldwork.dto;

import com.worldwork.beworldwork.entities.Company;

import java.time.LocalDate;

public class JobDTO {
    private Integer id;
    private String name;
    private String description;
    private String offer;
    private String requirement;
    private Integer fromSalary;
    private Integer toSalary;
    private LocalDate createAt;
    private Company company;
}
