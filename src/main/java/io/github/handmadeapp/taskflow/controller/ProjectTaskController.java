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
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectTaskController
{
  public final TaskService taskService;

  @GetMapping("/{projectId}/tasks")
  public ResponseEntity<List<TaskResponseDto>> getTasksByProjectId(@PathVariable Long projectId)
  {
    return ResponseEntity.ok(taskService.findTasksByProjectId(projectId));
  }
}