package com.worldwork.beworldwork.services;

import com.worldwork.beworldwork.dto.CompanyCreateRequest;
import com.worldwork.beworldwork.dto.CompanyDTO;
import com.worldwork.beworldwork.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyServices {

    List<Company> findALl ();

    Optional<Company> findById(int id);

    Void deleteById(int id);

    Company createCompany(CompanyCreateRequest companyCreateRequest);

    Optional<Company> updateCompany(CompanyDTO companyCreateRequest, Integer id);


}
