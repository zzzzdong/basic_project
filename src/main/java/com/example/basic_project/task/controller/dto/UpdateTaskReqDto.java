package com.example.basic_project.task.controller.dto;

import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;

import java.time.LocalDate;

public class UpdateTaskReqDto {
    private String title;
    private String description;
    private Priority priority;
    private Status taskStatus;
    private Member assigneeId;
    private LocalDate dueDate;
    private LocalDate startedAt;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public Member getAssigneeId() {
        return assigneeId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }
}
