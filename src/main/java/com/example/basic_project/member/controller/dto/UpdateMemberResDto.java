package com.example.basic_project.member.controller.dto;

public class UpdateMemberResDto {

    private Integer status;
    private String message;
    private Long id;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

    public UpdateMemberResDto(Integer status, String message, Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }
}
