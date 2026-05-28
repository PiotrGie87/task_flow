package io.github.handmadeapp.taskflow.controller;


import java.util.List;

import io.github.handmadeapp.taskflow.dto.task.TaskResponseDto;
import io.github.handmadeapp.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserTaskController
{
  private final TaskService taskService;

  @GetMapping("/{userId}/tasks")
  public ResponseEntity<List<TaskResponseDto>> getTasksByUserId(@PathVariable Long userId)
  {
    return ResponseEntity.ok(taskService.findTasksByUserId(userId));
  }

}