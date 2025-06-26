package com.example.basic_project.member.controller.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class DeleteMemberResDto {

    private Long id;

    private LocalDateTime deletedAt;

    private String message;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public String getMessage() {
        return message;
    }
}
