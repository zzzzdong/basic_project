package com.example.basic_project.member.service;

import com.example.basic_project.member.controller.dto.*;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성
    public CreateMemberResDto createMember(CreateMemberReqDto dto) {

        Member member = Member.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();

        memberRepository.save(member);

        return CreateMemberResDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .createdAt(member.getCreatedAt())
                .build();

    }

    // 단건 조회
    public MemberResDto getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 회원이 존재하지 않습니다."));
        return MemberResDto.from(member);
    }

    // 전체 조회
    public List<MemberResDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResDto> result = new ArrayList<>();

        for (Member member : members) {
            result.add(MemberResDto.from(member));
        }

        return result;
    }

     // 수정
    @Transactional
    public MemberResDto updateMember(Long id, UpdateMemberReqDto dto) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isEmpty() || optionalMember.get().isDeleted()) {
            throw new EntityNotFoundException("해당 회원이 존재하지 않습니다.");
        }

        Member member = optionalMember.get();
        member.update(dto.getName(), dto.getPassword());

        return MemberResDto.from(member);
    }

    // 삭제
    @Transactional
    public DeleteMemberResDto deleteMember(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isEmpty() || optionalMember.get().isDeleted()) {
            throw new EntityNotFoundException("해당 회원이 존재하지 않습니다.");
        }

        Member member = optionalMember.get();
        member.softDelete();

        return DeleteMemberResDto.builder()
                .id(member.getId())
                .deletedAt(member.getDeletedAt())
                .message("회원이 삭제되었습니다.")
                .build();
    }


}
