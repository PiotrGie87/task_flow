
package io.github.handmadeapp.taskflow.dto;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskRequestDto
{
  @NotBlank
  @Size(min = 3, max = 100)
  private String title;

  @NotBlank //works only for Strings
  @Size(max = 5000)
  private String description;

  @NotNull
  private TaskStatus status;

  @NotNull
  private Priority priority;

  @Future
  private LocalDateTime dueDate;

  private Long userId;

  @NotNull
  private Long projectId;
}