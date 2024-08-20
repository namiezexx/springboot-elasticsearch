package com.example.es.dto;

import com.example.es.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyResponseDto {

    Long companyId;
    String companyName;

    public static CompanyResponseDto from(Company company) {
        return new CompanyResponseDto(company.getCompanyId(), company.getCompanyName());
    }
}
