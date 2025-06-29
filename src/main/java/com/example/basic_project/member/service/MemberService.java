package com.example.basic_project.member.service;

import com.example.basic_project.member.controller.dto.CreateMemberReqDto;
import com.example.basic_project.member.controller.dto.CreateMemberResDto;
import com.example.basic_project.member.controller.dto.ReadDetailMemberResDto;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {

    // 속
    private final MemberRepository memberRepository;

    // 생
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 기

    // 생성
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

    // 단건 조회
    public ReadDetailMemberResDto getMemberService(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()) {
            Member foundMember = memberOptional.get();
            Long foundMemberId = foundMember.getId();
            String foundMemberName = foundMember.getName();
            LocalDateTime foundMemberCreatedAt = foundMember.getCreatedAt();
            LocalDateTime foundMemberUpdatedAt = foundMember.getUpdatedAt();
            Integer status = 200;
            String message = "success";

            ReadDetailMemberResDto resDto = new ReadDetailMemberResDto(status, message, foundMemberId, foundMemberName, foundMemberCreatedAt, foundMemberUpdatedAt);
            return resDto;

        } else {
            Integer status = 404;
            String message = "회원을 찾을 수 없습니다.";

            ReadDetailMemberResDto resDto = new ReadDetailMemberResDto(status, message, null, null, null, null);
            return resDto;
        }
    }
}