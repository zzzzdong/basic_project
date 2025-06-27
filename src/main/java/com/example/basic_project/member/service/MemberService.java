package com.example.basic_project.member.service;

import com.example.basic_project.member.controller.dto.CreateMemberReqDto;
import com.example.basic_project.member.controller.dto.CreateMemberResDto;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    // 속
    private final MemberRepository memberRepository;

    // 생
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 기
    public CreateMemberResDto createMemberService(CreateMemberReqDto reqDto) {
        String email = reqDto.getEmail();
        String name = reqDto.getName();
        String password = reqDto.getPassword();

        Member member = new Member(email, password, name);

        Member savedmember= memberRepository.save(member);
        Long savedMemberId = savedmember.getId();

        CreateMemberResDto resDto =  new CreateMemberResDto(201, "회원 생성 되었습니다.", savedMemberId);
        return resDto;
    }
}