package com.example.basic_project.task.domain.entity;

import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Member assignee;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    private LocalDate dueDate;
    private LocalDate startedAt;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;




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

    public Member getAssignee() {
        return assignee;
    }

    public Member getAuthor() {
        return author;
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

    public Task() {

    }

    public Task(String title,
                String description,
                Priority priority,
                Member assignee,
                Member author,
                LocalDate dueDate,
                LocalDate startedAt,
                Status taskStatus
    ) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.author = author;
        this.dueDate = dueDate;
        this.startedAt = startedAt;
        this.taskStatus = taskStatus;
        this.isDeleted = false;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
        this.updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    public Long getId() {
        return id;
    }

    public void updateTask(
            String title,
            String description,
            Priority priority,
            Status taskStatus,
            Member assignee,
            LocalDate dueDate,
            LocalDate startedAt
    ) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.startedAt = startedAt;
    }

    public void softDelete() {
        this.isDeleted = true;
    }




}
