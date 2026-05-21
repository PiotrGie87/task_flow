
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;
import java.util.List;

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

  @Future
  private LocalDateTime deadline;

  @Enumerated(EnumType.STRING)
  private ProjectStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "project",
              cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  private List<Task> tasks;

  public Project(String name, String description, LocalDateTime deadLine, ProjectStatus projectStatus)
  {
    this.name = name;
    this.description = description;
    this.deadline = deadLine;
    this.status = projectStatus;
  }

}