package com.example.basic_project.member.controller.dto;

import java.util.List;

public class ReadMembersResDto {
    private Integer status;
    private String message;
    private List<MemberDto> memberList;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<MemberDto> getMemberList() {
        return memberList;
    }

    public ReadMembersResDto(Integer status, String message, List<MemberDto> memberList) {
        this.status = status;
        this.message = message;
        this.memberList = memberList;
    }
}
