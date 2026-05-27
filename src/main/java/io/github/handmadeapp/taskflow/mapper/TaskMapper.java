
package io.github.handmadeapp.taskflow.mapper;

import io.github.handmadeapp.taskflow.dto.task.TaskRequestDto;
import io.github.handmadeapp.taskflow.dto.task.TaskResponseDto;
import io.github.handmadeapp.taskflow.entity.Task;

public class TaskMapper
{
  //empty private constructor. This prevents from creating a mapper in other classes. This is stateles utility class
  private TaskMapper(){

  }

  //mapper has no state so the methods might be static
  //no need to create new TaskMapper object

  public static Task toEntity(TaskRequestDto dto)
  {
    Task task = new Task();

    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setStatus(dto.getStatus());
    task.setPriority(dto.getPriority());
    task.setDueDate(dto.getDueDate());

    return task;
  }

  public static TaskResponseDto toResponseDto(Task task)
  {
    TaskResponseDto dto = new TaskResponseDto();

    dto.setId(task.getId());
    dto.setTitle(task.getTitle());
    dto.setDescription(task.getDescription());
    dto.setStatus(task.getStatus());
    dto.setPriority(task.getPriority());
    dto.setDueDate(task.getDueDate());
    dto.setCreatedAt(task.getCreatedAt());
    dto.setUpdatedAt(task.getUpdatedAt());

    if (task.getUser() != null)
    {
      dto.setUserId(task.getUser().getId());
      dto.setUsername(task.getUser().getUsername());
    }

    if (task.getProject() != null)
    {
      dto.setProjectId(task.getProject().getId());
    }

    return dto;
  }

}