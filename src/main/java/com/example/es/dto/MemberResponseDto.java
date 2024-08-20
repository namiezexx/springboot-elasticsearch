package com.example.es.dto;

import com.example.es.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponseDto {

    Long memberId;
    String memberName;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(member.getMemberId(), member.getMemberName());
    }
}
