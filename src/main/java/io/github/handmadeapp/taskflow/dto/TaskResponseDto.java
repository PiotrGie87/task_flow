
package io.github.handmadeapp.taskflow.dto;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDto
{
  private Long id;
  private String title;
  private String description;
  private TaskStatus status;
  private Priority priority;
  private LocalDateTime dueDate;
  private LocalDateTime createdAt;
  private Long userId;
  private String username;
  private Long projectId;
}