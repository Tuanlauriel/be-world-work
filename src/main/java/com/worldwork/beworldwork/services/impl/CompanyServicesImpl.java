package com.worldwork.beworldwork.services.impl;

import com.worldwork.beworldwork.dto.CompanyCreateRequest;
import com.worldwork.beworldwork.dto.CompanyDTO;
import com.worldwork.beworldwork.entities.Company;
import com.worldwork.beworldwork.repositories.CompanyRepository;
import com.worldwork.beworldwork.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServicesImpl implements CompanyServices {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServicesImpl (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Company> findALl() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public Void deleteById(int id) {
        companyRepository.deleteById(id);
        return null;
    }

    @Override
    public Company createCompany(CompanyCreateRequest companyCreateRequest) {
        Company theCompany = Company.builder()
                .company_id(0)
                .name(companyCreateRequest.getName())
                .email(companyCreateRequest.getEmail())
                .address(companyCreateRequest.getAddress())
                .banner(companyCreateRequest.getBanner())
                .logo(companyCreateRequest.getLogo())
                .phone(companyCreateRequest.getPhone())
                .businessLicense(companyCreateRequest.getBusinessLicense())
                .status(false)
                .description(companyCreateRequest.getDescription())
                .website(companyCreateRequest.getWebsite())
                .build();
        return companyRepository.save(theCompany);
    }

    @Override
    public Optional<Company> updateCompany(CompanyDTO companyCreateRequest, Integer id) {
        Optional<Company> theCompany = companyRepository.findById(id);
        if (theCompany.isPresent()) {
            Company company = theCompany.get();
            company.setName(companyCreateRequest.getName());
            company.setAddress(companyCreateRequest.getAddress());
            company.setBanner(companyCreateRequest.getBanner());
            company.setLogo(companyCreateRequest.getLogo());
            company.setEmail(companyCreateRequest.getEmail());
            company.setBusinessLicense(companyCreateRequest.getBusinessLicense());
            company.setDescription(companyCreateRequest.getDescription());
            company.setPhone(companyCreateRequest.getPhone());
            company.setWebsite(companyCreateRequest.getWebsite());
            companyRepository.save(company);
            return theCompany;
        }
        return null;
    }
}
