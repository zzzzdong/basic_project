package com.example.basic_project.member.controller;

import com.example.basic_project.member.controller.dto.*;
import com.example.basic_project.member.domain.repository.MemberRepository;
import com.example.basic_project.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    // 속
    private final MemberService memberService;

    // 생
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 기

    // 멤버 생성
    @PostMapping
    public ResponseEntity<CreateMemberResDto> createMember(@RequestBody CreateMemberReqDto reqDto) {
        CreateMemberResDto resDto = memberService.createMemberService(reqDto);

        ResponseEntity<CreateMemberResDto> response = new ResponseEntity<>(resDto, HttpStatus.CREATED);
        return response;
    }

    // 멤버 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ReadDetailMemberResDto> getMember(@PathVariable Long id) {
        ReadDetailMemberResDto resDto = memberService.getMemberService(id);

        ResponseEntity<ReadDetailMemberResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }

    // 멤버 전체 조회
    @GetMapping
    public ResponseEntity<ReadMembersResDto> getMembers() {
        ReadMembersResDto resDto = memberService.getMembersService();

        ResponseEntity<ReadMembersResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }

    // 멤버 수정
    @PutMapping("/{id}")
    public ResponseEntity<UpdateMemberResDto> updateMember(
            @PathVariable Long id,
            @RequestBody UpdateMemberReqDto reqDto
    ) {
        UpdateMemberResDto resDto = memberService.updateMemberService(id, reqDto);
        ResponseEntity<UpdateMemberResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;

    }

    // 멤버 삭제(soft)
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMemberResDto> deleteMember(@PathVariable Long id) {

        DeleteMemberResDto resDto = memberService.deleteMemberService(id);

        ResponseEntity<DeleteMemberResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }



}