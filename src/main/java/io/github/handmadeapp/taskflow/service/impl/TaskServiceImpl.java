
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.TaskResponseDto;
import io.github.handmadeapp.taskflow.entity.Project;
import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import io.github.handmadeapp.taskflow.exception.ProjectNotFoundException;
import io.github.handmadeapp.taskflow.exception.UserNotFoundException;
import io.github.handmadeapp.taskflow.mapper.TaskMapper;
import io.github.handmadeapp.taskflow.repository.ProjectRepository;
import io.github.handmadeapp.taskflow.repository.TaskRepository;
import io.github.handmadeapp.taskflow.repository.UserRepository;
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
  private final ProjectRepository projectRepository;
  private final UserRepository userRepository;

  @Override
  public TaskResponseDto createTask(TaskRequestDto requestDto)
  {
    Task task = TaskMapper.toEntity(requestDto);

    //Project is mandatory
    Project project = projectRepository.findById(requestDto.getProjectId())
                                        .orElseThrow(() -> new ProjectNotFoundException("project not found"));

    task.setProject(project);

    //User is optional
    if (requestDto.getUserId() != null)
    {
      User user = userRepository.findById(requestDto.getUserId())
                                .orElseThrow(() -> new UserNotFoundException("Id not found"));
      task.setUser(user);
    }

    //Save new task in DB
    Task savedTask = taskRepository.save(task);

    return TaskMapper.toResponseDto(savedTask);
  }

  @Override
  public Task updateTask(Task task)
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
  public List<TaskResponseDto> findAllTasks()
  {
    return taskRepository.findAll().stream().map(TaskMapper::toResponseDto).toList();
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