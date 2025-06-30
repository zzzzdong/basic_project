package com.example.basic_project.task.controller;

import com.example.basic_project.member.controller.dto.CreateMemberReqDto;
import com.example.basic_project.member.controller.dto.CreateMemberResDto;
import com.example.basic_project.member.controller.dto.ReadMembersResDto;
import com.example.basic_project.task.controller.dto.*;
import com.example.basic_project.task.service.TaskService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    // 속
    private final TaskService taskService;

    // 생
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 기

    // 태스크 생성
    @PostMapping
    public ResponseEntity<CreateTaskResDto> CreateTask(@RequestBody CreateTaskReqDto reqDto) {
        CreateTaskResDto resDto = taskService.createTaskService(reqDto);

        ResponseEntity<CreateTaskResDto> response = new ResponseEntity<>(resDto, HttpStatus.CREATED);
        return response;
    }

    // 태스크 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ReadDetailTaskResDto> getTask(@PathVariable Long id) {
        ReadDetailTaskResDto resDto = taskService.getTaskService(id);

        ResponseEntity<ReadDetailTaskResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }

    // 태스크 전체 조회
    @GetMapping
    public ResponseEntity<ReadTasksResDto> getTasks() {
        ReadTasksResDto resDto = taskService.getTasksService();

        ResponseEntity<ReadTasksResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }

    // 태스크 수정
    @PutMapping("/{id}")
    public ResponseEntity<UpdateTaskResDto> updateTask(@PathVariable Long id, @RequestBody UpdateTaskReqDto reqDto) {
        UpdateTaskResDto resDto = taskService.updateTaskService(id, reqDto);
        ResponseEntity<UpdateTaskResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }

    // 태스크 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTaskResDto> deleteTask(@PathVariable Long id) {

        DeleteTaskResDto resDto = taskService.deleteTaskService(id);

        ResponseEntity<DeleteTaskResDto> response = new ResponseEntity<>(resDto, HttpStatus.OK);
        return response;
    }
}
