
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.ProjectStatus;
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
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NotBlank
public class Project
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String name;

  @NotBlank
  @Size(max = 500)
  private String description;

  @NotBlank
  @Future
  private LocalDateTime deadline;

  @Enumerated(EnumType.STRING)
  private ProjectStatus status;

  @NotBlank
  @CreationTimestamp
  private LocalDateTime createdAt;

}