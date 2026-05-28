package io.github.handmadeapp.taskflow.controller;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.task.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.task.TaskResponseDto;
import io.github.handmadeapp.taskflow.dto.task.UpdateTaskRequestDto;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
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

  @GetMapping("/{taskId}")
  public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long taskId)
  {
    return ResponseEntity.ok(taskService.findTaskById(taskId));
  }

  @PostMapping
  public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto requestDto)
  {
    TaskResponseDto createdTask = taskService.createTask(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<TaskResponseDto> updateTask(
                                          @PathVariable Long taskId,
                                          @Valid @RequestBody UpdateTaskRequestDto requestDto)
  {
    TaskResponseDto updatedTask = taskService.updateTask(taskId, requestDto);

    return ResponseEntity.ok(updatedTask);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long taskId)
  {
    taskService.deleteTaskById(taskId);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<TaskResponseDto>> getTasksByStatus(@PathVariable TaskStatus status)
  {
    return ResponseEntity.ok(taskService.findTasksByStatus(status));
  }

  @GetMapping("/priority/{priority}")
  public ResponseEntity<List<TaskResponseDto>> getTasksByPriority(@PathVariable Priority priority)
  {
    return ResponseEntity.ok(taskService.findTasksByPriority(priority));
  }
}