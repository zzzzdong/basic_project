package com.example.basic_project.task.service;

import com.example.basic_project.member.controller.dto.ReadMembersResDto;
import com.example.basic_project.member.domain.entity.Member;
import com.example.basic_project.member.domain.repository.MemberRepository;
import com.example.basic_project.task.controller.dto.*;
import com.example.basic_project.task.domain.entity.Task;
import com.example.basic_project.task.domain.enums.Priority;
import com.example.basic_project.task.domain.enums.Status;
import com.example.basic_project.task.domain.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TaskService {

    // 속
    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    // 생
    public TaskService(TaskRepository taskRepository, MemberRepository memberRepository) {
        this.taskRepository = taskRepository;
        this.memberRepository = memberRepository;
    }

    // 기

    // 생성
    public CreateTaskResDto createTaskService(CreateTaskReqDto reqDto) {
        String title = reqDto.getTitle();
        String description = reqDto.getDescription();
        Priority priority = reqDto.getPriority();
        Long assigneeId = reqDto.getAssigneeId();
        Long authorId = reqDto.getAuthorId();
        LocalDate dueDate = reqDto.getDueDate();
        LocalDate startedAt = reqDto.getStartedAt();
        Status taskStatus = reqDto.getTaskStatus();

        Member assignee = memberRepository.findById(assigneeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 담당자를 찾을 수 없습니다."));

        Member author = memberRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("해당 작성자를 찾을 수 없습니다."));

        Task task = new Task(title, description, priority, assignee, author, dueDate, startedAt, taskStatus);

        Task savedtask = taskRepository.save(task);
        Long savedTaskId = savedtask.getId();

        CreateTaskResDto resDto = new CreateTaskResDto(201, "작업이 생성되었습니다.", savedTaskId);
        return resDto;
    }

    // 단건 조회
    public ReadDetailTaskResDto getTaskService(Long id) {
        Task foundTask = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 작업을 찾을 수 없습니다."));

        return new ReadDetailTaskResDto(
                200,
                "success",
                foundTask.getId(),
                foundTask.getTitle(),
                foundTask.getDescription(),
                foundTask.getPriority(),
                foundTask.getTaskStatus(),
                foundTask.getAssignee().getId(),
                foundTask.getAuthor().getId(),
                foundTask.getDueDate(),
                foundTask.getStartedAt(),
                foundTask.getCreatedAt(),
                foundTask.getUpdatedAt()
        );
    }

    // 전체 조회
    public ReadTasksResDto getTasksService() {
        List<Task> taskList = taskRepository.findAll();

        List<TaskDto> taskDtoList = taskList.stream()
                .map(task -> new TaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getPriority(),
                        task.getTaskStatus(),
                        task.getAssignee(),
                        task.getAuthor(),
                        task.getDueDate(),
                        task.getCreatedAt(),
                        task.getUpdatedAt())
                ).collect(Collectors.toList());

        ReadTasksResDto resDto = new ReadTasksResDto(200, "success", taskDtoList);

        return resDto;
    }

    // 수정
    public UpdateTaskResDto updateTaskService(Long id, UpdateTaskReqDto reqDto) {
        String title = reqDto.getTitle();
        String description = reqDto.getDescription();
        Priority priority = reqDto.getPriority();
        Status taskStatus = reqDto.getTaskStatus();
        Member assigneeId = reqDto.getAssigneeId();
        LocalDate dueDate = reqDto.getDueDate();
        LocalDate startedAt = reqDto.getStartedAt();

        Task foundTask = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 작업을 찾을 수 없습니다."));

        foundTask.updateTask(title, description, priority, taskStatus, assigneeId, dueDate, startedAt);

        return new UpdateTaskResDto(200, "updated", foundTask.getId());
    }

    // 삭제
    public DeleteTaskResDto deleteTaskService(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 작업을 찾을 수 없습니다."));

        task.softDelete();

        return new DeleteTaskResDto(200, "deleted");
    }
}
