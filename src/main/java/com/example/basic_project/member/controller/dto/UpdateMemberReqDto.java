package com.example.basic_project.member.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateMemberReqDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
