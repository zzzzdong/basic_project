package com.example.basic_project.member.controller.dto;

import com.example.basic_project.member.domain.enums.Role;

import java.time.LocalDateTime;

//ReadMembersResDto에서 활용
public class MemberDto {
    private Long id;
    private String name;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public MemberDto(Long id, String name, Role role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
