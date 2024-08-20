package com.example.es.controller;

import com.example.es.dto.MemberResponseDto;
import com.example.es.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public List<MemberResponseDto> getMembers() {
        log.info("call getMember");
        return memberService.getMembers();
    }

    @GetMapping("/exception")
    public String throwException() throws Exception {
        log.info("call throwException");
        throw new RuntimeException("이건 에러입니다.");
    }

}
