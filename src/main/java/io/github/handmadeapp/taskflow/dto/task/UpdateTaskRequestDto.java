
package io.github.handmadeapp.taskflow.dto.task;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateTaskRequestDto
{

  private String title;
  private String description;
  private TaskStatus status;
  private Priority priority;
  @Future
  private LocalDateTime dueDate;
  private Long userId;

}