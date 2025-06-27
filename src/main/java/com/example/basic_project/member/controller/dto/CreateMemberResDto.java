package com.example.basic_project.member.controller.dto;

public class CreateMemberResDto {
    private Integer status;
    private String message;
    private Long id;

    public CreateMemberResDto(Integer status, String message, Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }



}
