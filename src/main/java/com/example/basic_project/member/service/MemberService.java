package com.example.basic_project.member.service;

import com.example.basic_project.member.controller.dto.*;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.enums.Role;
import com.example.basic_project.member.domain.repository.MemberRepository;
import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Role role = reqDto.getrole();

        Member member = new Member(email, password, name, role);

        Member savedmember = memberRepository.save(member);
        Long savedMemberId = savedmember.getId();

        CreateMemberResDto resDto =  new CreateMemberResDto(201, "회원 생성 되었습니다.", savedMemberId);
        return resDto;
    }

    // 단건 조회
    public ReadDetailMemberResDto getMemberService(Long id) {
        Member foundMember = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));


        return new ReadDetailMemberResDto(
                200,
                "success",
                foundMember.getId(),
                foundMember.getName(),
                foundMember.getRole(),
                foundMember.getCreatedAt(),
                foundMember.getUpdatedAt()
        );

//        Optional<Member> memberOptional = memberRepository.findById(id);
//
//        if (memberOptional.isPresent()) {
//            Member foundMember = memberOptional.get();
//            Long foundMemberId = foundMember.getId();
//            String foundMemberName = foundMember.getName();
//            LocalDateTime foundMemberCreatedAt = foundMember.getCreatedAt();
//            LocalDateTime foundMemberUpdatedAt = foundMember.getUpdatedAt();
//            Integer status = 200;
//            String message = "success";
//
//            ReadDetailMemberResDto resDto = new ReadDetailMemberResDto(status, message, foundMemberId, foundMemberName, foundMemberCreatedAt, foundMemberUpdatedAt);
//            return resDto;
//
//        } else {
//            Integer status = 404;
//            String message = "회원을 찾을 수 없습니다.";
//
//            ReadDetailMemberResDto resDto = new ReadDetailMemberResDto(
//                    status,
//                    message,
//                    null,
//                    null,
//                    null,
//                    null);
//            return resDto;
//        }
    }

    // 전체 조회
    public ReadMembersResDto getMembersService() {
        List<Member> memberList = memberRepository.findAll();


//        List<MemberDto> memberDtoList = new ArrayList<>();
//
//        for (Member member : memberList) {
//            MemberDto memberDto = new MemberDto(
//                    member.getId(),
//                    member.getName(),
//                    member.getCreatedAt(),
//                    member.getUpdatedAt());
//            memberDtoList.add(memberDto);
//        }

        // for 문 -> 스트림 변경
        List<MemberDto> memberDtoList = memberList.stream()
                .map(member -> new MemberDto(
                        member.getId(),
                        member.getName(),
                        member.getRole(),
                        member.getCreatedAt(),
                        member.getUpdatedAt())
                ).collect(Collectors.toList());

        ReadMembersResDto resDto = new ReadMembersResDto(200, "success", memberDtoList);

        return resDto;
    }

    // 수정
    @Transactional
    public UpdateMemberResDto updateMemberService(
            Long id,
            UpdateMemberReqDto reqDto
    ) {
        String name = reqDto.getName();
        String password = reqDto.getPassword();
        Role role = reqDto.getRole();

        Member foundMember = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        foundMember.updateMember(name, password, role);

        return new UpdateMemberResDto(200, "updated", foundMember.getId());

//        Optional<Member> memberOptional = memberRepository.findById(id);
//        if (memberOptional.isPresent()) {
//            Member foundmember = memberOptional.get();
//
//            foundmember.updateMember(name, password);
//
//            UpdateMemberResDto resDto = new UpdateMemberResDto(200, "updated", foundmember.getId());
//            return resDto;
//
//        } else {
//            Integer status = 404;
//            String message = "회원을 찾을 수 없습니다.";
//
//            return new UpdateMemberResDto(status, message, null);
//       }

    }

    // 삭제
    @Transactional
    public DeleteMemberResDto deleteMemberService(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        member.softDelete();

        return new DeleteMemberResDto(200, "deleted");

    }
}