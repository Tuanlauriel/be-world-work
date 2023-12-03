package com.worldwork.beworldwork.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class CompanyCreateRequest {

    @NotEmpty(message = "The name of company is null!")
    private String name;

    @NotEmpty(message = "The logo of company is null!")
    private String logo;

    @NotEmpty(message = "The address of company is null!")
    private String address;

    @NotEmpty(message = "The website of company is null!")
    private String website;

    @Email(message = "The email is not valid")
    private String email;

    @NotEmpty(message = "The phone of company is null!")
    private String phone;

    @NotEmpty(message = "The description of company is null!")
    private String description;

    @NotEmpty(message = "The banner of company is null!")
    private String banner;

    @NotEmpty(message = "The businesslicense of company is null!")
    private String businessLicense;

}
