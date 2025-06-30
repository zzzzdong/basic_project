package com.example.basic_project.task.controller.dto;

import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReadDetailTaskResDto {
    private Integer status;
    private String message;
    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private Status taskStatus;
    private Member assigneeId;
    private Member authorId;
    private LocalDate dueDate;
    private LocalDate startedAt;
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

    public Member getAuthorId() {
        return authorId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ReadDetailTaskResDto(
            Integer status,
            String message,
            Long id,
            String title,
            String description,
            Priority priority,
            Status taskStatus,
            Member assigneeId,
            Member authorId,
            LocalDate dueDate,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.status = status;
        this.message = message;
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.assigneeId = assigneeId;
        this.authorId = authorId;
        this.dueDate = dueDate;
        this.startedAt = startedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
