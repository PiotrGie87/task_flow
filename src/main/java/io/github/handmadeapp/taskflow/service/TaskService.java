package io.github.handmadeapp.taskflow.service;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.task.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.task.TaskResponseDto;
import io.github.handmadeapp.taskflow.dto.task.UpdateTaskRequestDto;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;

public interface TaskService
{
  TaskResponseDto createTask(TaskRequestDto requestDto);

  TaskResponseDto updateTask(Long taskId, UpdateTaskRequestDto requestDto);

  void deleteTaskById(Long taskId);

  TaskResponseDto findTaskById(Long taskId);

  List<TaskResponseDto> findAllTasks();

  List<TaskResponseDto> findTasksByUserId(Long userId);

  List<TaskResponseDto> findTasksByProjectId(Long projectId);

  List<TaskResponseDto> findTasksByStatus(TaskStatus taskStatus);

  List<TaskResponseDto> findTasksByPriority(Priority taskPriority);
}
