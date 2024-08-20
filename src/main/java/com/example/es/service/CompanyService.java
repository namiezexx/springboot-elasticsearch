package com.example.es.service;

import com.example.es.dto.CompanyResponseDto;
import com.example.es.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<CompanyResponseDto> getCompanies() {
        return companyRepository.findAll().stream()
                .map(CompanyResponseDto::from)
                .toList();
    }
}
