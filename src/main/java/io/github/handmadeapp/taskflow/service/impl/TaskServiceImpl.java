
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;

import io.github.handmadeapp.taskflow.dto.task.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.task.TaskResponseDto;
import io.github.handmadeapp.taskflow.dto.task.UpdateTaskRequestDto;
import io.github.handmadeapp.taskflow.entity.Project;
import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import io.github.handmadeapp.taskflow.exception.ProjectNotFoundException;
import io.github.handmadeapp.taskflow.exception.TaskNotFoundException;
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
  public TaskResponseDto updateTask(Long taskId, UpdateTaskRequestDto requestDto)
  {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));

    if (requestDto.getTitle() != null) task.setTitle(requestDto.getTitle());
    if (requestDto.getDescription() != null) task.setDescription(requestDto.getDescription());
    if (requestDto.getStatus() != null) task.setStatus(requestDto.getStatus());
    if (requestDto.getPriority() != null) task.setPriority(requestDto.getPriority());
    if (requestDto.getDueDate() != null) task.setDueDate(requestDto.getDueDate());

    if (requestDto.getUserId() != null)
    {
      User user = userRepository.findById(requestDto.getUserId())
                                .orElseThrow(() -> new UserNotFoundException("User not found"));
      task.setUser(user);
    }

    taskRepository.flush(); //to have a fresh updatedAt field we need to have flush manually

    return TaskMapper.toResponseDto(task);
  }

  @Override
  public void deleteTaskById(Long taskId)
  {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
    taskRepository.delete(task);
  }

  @Override
  public TaskResponseDto findTaskById(Long taskId)
  {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));

    return TaskMapper.toResponseDto(task);
  }

  @Override
  public List<TaskResponseDto> findAllTasks()
  {
    return taskRepository.findAll().stream().map(TaskMapper::toResponseDto).toList();

  }

  @Override
  public List<TaskResponseDto> findTasksByUserId(Long userId)
  {
    return taskRepository.findByUserId(userId).stream().map(TaskMapper::toResponseDto).toList();
  }

  @Override
  public List<TaskResponseDto> findTasksByProjectId(Long projectId)
  {
    return taskRepository.findByProjectId(projectId).stream().map(TaskMapper::toResponseDto).toList();
  }

  @Override
  public List<TaskResponseDto> findTasksByStatus(TaskStatus taskStatus)
  {
    return taskRepository.findByStatus(taskStatus).stream().map(TaskMapper::toResponseDto).toList();
  }

  @Override
  public List<TaskResponseDto> findTasksByPriority(Priority taskPriority)
  {
    return taskRepository.findByPriority(taskPriority).stream().map(TaskMapper::toResponseDto).toList();
  }
}