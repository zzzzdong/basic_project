package com.example.basic_project.member.controller.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class CreateMemberResDto {
    private Long id;
    private String email;
    private String Password;
    private String name;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
