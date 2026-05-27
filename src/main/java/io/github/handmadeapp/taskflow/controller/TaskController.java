
package io.github.handmadeapp.taskflow.controller;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.TaskResponseDto;
import io.github.handmadeapp.taskflow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController
{
  private final TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskResponseDto>> getAllTasks()
  {
    return ResponseEntity.ok(taskService.findAllTasks());
  }

  @PostMapping
  public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto requestDto)
  {
    TaskResponseDto createdTask = taskService.createTask(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
  }

}