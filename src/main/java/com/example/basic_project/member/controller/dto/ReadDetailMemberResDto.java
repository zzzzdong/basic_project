package com.example.basic_project.member.controller.dto;

import java.time.LocalDateTime;

public class ReadDetailMemberResDto {
    private Integer status;
    private String message;
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ReadDetailMemberResDto(Integer status, String message, Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.status = status;
        this.message = message;
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
