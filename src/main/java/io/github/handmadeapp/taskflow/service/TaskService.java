package io.github.handmadeapp.taskflow.service;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.TaskResponseDto;
import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;

public interface TaskService
{
  TaskResponseDto createTask(TaskRequestDto requestDto);

  Task updateTask(Task task);

  void deleteTaskById(Long taskId);

  Task findTaskById(Long taskId);

  List<TaskResponseDto> findAllTasks();

  List<Task> findTaskByUserId(Long userId);

  List<Task> findTaskByProjectId(Long projectId);

  List<Task> findByStatus(TaskStatus taskStatus);

  List<Task> findByPriority(Priority taskPriority);
}
