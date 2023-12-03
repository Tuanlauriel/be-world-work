package com.worldwork.beworldwork.dto;

import com.worldwork.beworldwork.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    public CompanyDTO (Company company) {
        this.name = company.getName();
        this.logo = company.getLogo();
        this.address = company.getAddress();
        this.website = company.getWebsite();
        this.email = company.getEmail();
        this.phone = company.getPhone();
        this.description = company.getDescription();
        this.banner = company.getBanner();
        this.company_id = company.getCompany_id();
        this.status = company.getStatus();
        this.businessLicense = company.getBusinessLicense();
    }

    private Integer company_id;

    private String name;

    private String logo;

    private String address;

    private String website;

    private String email;

    private String phone;

    private String description;

    private String banner;

    private Boolean status;

    private String businessLicense;
}
