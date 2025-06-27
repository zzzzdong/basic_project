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
}