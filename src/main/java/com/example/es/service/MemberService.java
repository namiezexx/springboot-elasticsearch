package com.example.es.service;

import com.example.es.dto.MemberResponseDto;
import com.example.es.entity.Company;
import com.example.es.entity.Member;
import com.example.es.repository.CompanyRepository;
import com.example.es.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    public List<MemberResponseDto> getMembers() {
        List<Member> memberList = memberRepository.findAll();
        List<Company> companyList = companyRepository.findAll();
        return memberList.stream()
                .map(MemberResponseDto::from)
                .toList();
    }

    @PostConstruct
    public void initData() {
        Member user = new Member();
        user.setMemberName("이재석");
        memberRepository.save(user);

        user = new Member();
        user.setMemberName("김아름");
        memberRepository.save(user);

        user = new Member();
        user.setMemberName("이우진");
        memberRepository.save(user);

        user = new Member();
        user.setMemberName("이우찬");
        memberRepository.save(user);

        user = new Member();
        user.setMemberName("홍길동");
        memberRepository.save(user);

        Company company = new Company();
        company.setCompanyName("회사");
        companyRepository.save(company);
    }

}
