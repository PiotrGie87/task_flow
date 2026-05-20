
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NotBlank
public class Task
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String title;

  @NotBlank
  @Size(max = 5000)
  private String description;

  @NotBlank
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @NotBlank
  @Enumerated(EnumType.STRING)
  private Priority priority;

  @NotBlank
  @Future
  private LocalDateTime dueDate;

  @NotBlank
  @CreationTimestamp
  private LocalDateTime createdAt;
}