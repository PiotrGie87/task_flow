package io.github.handmadeapp.taskflow.service;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;

public interface TaskService
{
  Task createTask(Task task);

  Task saveTask(Task task);

  void deleteTaskById(Long taskId);

  Task findTaskById(Long taskId);

  List<Task> findAllTasks();

  List<Task> findTaskByUserId(Long userId);

  List<Task> findTaskByProjectId(Long projectId);

  List<Task> findByStatus(TaskStatus taskStatus);

  List<Task> findByPriority(Priority taskPriority);
}
