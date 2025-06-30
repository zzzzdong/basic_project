package com.example.basic_project.member.controller.dto;

import com.example.basic_project.member.domain.enums.Role;

public class UpdateMemberReqDto {
    private String name;
    private String password;
    private Role role;

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
