
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import io.github.handmadeapp.taskflow.repository.TaskRepository;
import io.github.handmadeapp.taskflow.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService
{
  private final TaskRepository taskRepository;

  @Override
  public Task createTask(Task task)
  {
    return null;
  }

  @Override
  public Task saveTask(Task task)
  {
    return null;
  }

  @Override
  public void deleteTaskById(Long taskId)
  {

  }

  @Override
  public Task findTaskById(Long taskId)
  {
    return null;
  }

  @Override
  public List<Task> findAllTasks()
  {
    return List.of();
  }

  @Override
  public List<Task> findTaskByUserId(Long userId)
  {
    return List.of();
  }

  @Override
  public List<Task> findTaskByProjectId(Long projectId)
  {
    return List.of();
  }

  @Override
  public List<Task> findByStatus(TaskStatus taskStatus)
  {
    return List.of();
  }

  @Override
  public List<Task> findByPriority(Priority taskPriority)
  {
    return List.of();
  }
}