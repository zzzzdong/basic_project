package com.example.basic_project.member.controller.dto;

import com.example.basic_project.member.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateMemberReqDto {

    private String email;

    private String name;

    private String password;

    private Role role;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getrole() {
        return role;
    }
}
