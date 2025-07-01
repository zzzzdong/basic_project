package com.example.basic_project.task.controller.dto;

import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;

import java.time.LocalDate;

public class CreateTaskReqDto {
    private String title;

    private String description;

    private Priority priority;

    private Long assigneeId;

    private Long authorId;

    private LocalDate dueDate;

    private LocalDate startedAt;

    private Status taskStatus;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public CreateTaskReqDto(
            String title,
            String description,
            Priority priority,
            Long assigneeId,
            Long authorId,
            LocalDate dueDate,
            LocalDate startedAt,
            Status taskStatus
    ) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assigneeId = assigneeId;
        this.authorId = authorId;
        this.dueDate = dueDate;
        this.startedAt = startedAt;
        this.taskStatus = taskStatus;
    }
}
