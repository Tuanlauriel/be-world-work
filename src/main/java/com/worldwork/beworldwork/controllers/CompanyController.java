package com.worldwork.beworldwork.controllers;


import com.worldwork.beworldwork.dto.CompanyCreateRequest;
import com.worldwork.beworldwork.dto.CompanyDTO;
import com.worldwork.beworldwork.dto.MessageResponse;
import com.worldwork.beworldwork.entities.Company;
import com.worldwork.beworldwork.services.CompanyServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test/api/v1/companies")
public class CompanyController {

    private CompanyServices companyServices;

    @Autowired
    public CompanyController (CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompany() {
        List<Company> companyList = companyServices.findALl();
        for (Company company: companyList) {
            System.out.println(company.getCompany_id());
        }
        System.out.println("getAllCompany is running");
        List<CompanyDTO> companyDTOList = companyList.stream()
                .map(CompanyDTO::new).collect(Collectors.toList());
        for (CompanyDTO companyDTO:companyDTOList) {
            System.out.println(companyDTO.getCompany_id());
        }
        return ResponseEntity.ok(companyDTOList);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@Valid @RequestBody CompanyCreateRequest companyCreateRequest, BindingResult bindingResult) {
        //check # null of name,
        if( bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Some information has not been filled in"));
        }else {
            System.out.println(companyCreateRequest.toString());
            Company company = companyServices.createCompany(companyCreateRequest);
            CompanyDTO companyDTO = CompanyDTO.builder()
                    .company_id(company.getCompany_id())
                    .email(company.getEmail())
                    .name(company.getName())
                    .phone(company.getPhone())
                    .address(company.getAddress())
                    .businessLicense(company.getBusinessLicense())
                    .description(company.getDescription())
                    .website(company.getWebsite())
                    .logo(company.getLogo())
                    .banner(company.getBanner())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO);
        }
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable int companyId) {
        Company company = companyServices.findById(companyId).get();
        CompanyDTO companyDTO = CompanyDTO.builder()
                .company_id(company.getCompany_id())
                .banner(company.getBanner())
                .logo(company.getLogo())
                .website(company.getWebsite())
                .description(company.getDescription())
                .businessLicense(company.getBusinessLicense())
                .address(company.getAddress())
                .status(company.getStatus())
                .phone(company.getPhone())
                .email(company.getEmail())
                .build();
        return ResponseEntity.ok(companyDTO);
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteById(@PathVariable int id) {
        companyServices.deleteById(id);
        return new MessageResponse("Deleted company id - " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateCompany(@RequestBody CompanyDTO companyDTO, @PathVariable int id) {
        if(companyServices.updateCompany(companyDTO, id)!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("The company id - " + id + " has updated!!" ));
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Not found the company id - " + id + " to update"));
    }

}
