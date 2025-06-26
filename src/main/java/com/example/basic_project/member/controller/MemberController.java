package com.example.basic_project.member.controller;

import com.example.basic_project.member.controller.dto.*;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.repository.MemberRepository;
import com.example.basic_project.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@Builder
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 멤버 생성
    @PostMapping
    public ResponseEntity<CreateMemberResDto> createMember(
            @Validated @RequestBody CreateMemberReqDto dto) {

        CreateMemberResDto resDto = memberService.createMember(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resDto);
    }

    // 멤버 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResDto> getMemberById(
            @PathVariable Long id) {
        MemberResDto member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    // 멤버 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberResDto>> getAllMembers() {
        List<MemberResDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // 멤버 수정
    @PutMapping("/{id}")
    public ResponseEntity<MemberResDto> updateMember(
            @PathVariable Long id,
            @Validated @RequestBody UpdateMemberReqDto dto) {
        return ResponseEntity.ok(memberService.updateMember(id, dto));
    }

    // 멤버 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMemberResDto> deleteMember(
            @PathVariable Long id) {
        return ResponseEntity.ok(memberService.deleteMember(id));
    }



}
