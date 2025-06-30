package com.example.basic_project.task.domain.entity;

import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;
import jakarta.persistence.*;

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
                Member assigneeId,
                LocalDate dueDate,
                LocalDate startedAt,
                Status taskStatus
    ) {
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
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

    }

    public void softDalete() {
        this.isDeleted = true;
    }




}
