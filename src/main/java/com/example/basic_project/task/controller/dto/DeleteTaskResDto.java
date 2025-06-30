package com.example.basic_project.task.controller.dto;

public class DeleteTaskResDto {

    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DeleteTaskResDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
