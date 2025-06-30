package com.example.basic_project.task.controller.dto;

import com.example.basic_project.member.controller.dto.MemberDto;

import java.util.List;

public class ReadTasksResDto {
    private Integer status;
    private String message;
    private List<TaskDto> taskList;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<TaskDto> getTaskList() {
        return taskList;
    }

    public ReadTasksResDto(Integer status, String message, List<TaskDto> taskList) {
        this.status = status;
        this.message = message;
        this.taskList = taskList;
    }
}
