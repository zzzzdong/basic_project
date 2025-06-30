package com.example.basic_project.member.controller.dto;

public class DeleteMemberResDto {

    private Integer status;
    private String message;

    public DeleteMemberResDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
