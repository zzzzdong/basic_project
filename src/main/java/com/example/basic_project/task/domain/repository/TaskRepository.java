package com.example.basic_project.task.domain.repository;

import com.example.basic_project.task.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
