
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;
import java.util.List;

import io.github.handmadeapp.taskflow.enums.Priority;
import io.github.handmadeapp.taskflow.enums.TaskStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String title;

  @NotBlank //works only for Strings
  @Size(max = 5000)
  private String description;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Priority priority;

  @Future
  private LocalDateTime dueDate;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
  @JoinColumn(name = "project_id")
  private Project project;

  @OneToMany(mappedBy = "task", //refers to "user" property in the Task class
   cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
   fetch = FetchType.LAZY)  //DO NOT APPLY CASCADING DELETES!
  private List<Comment> comments;

  public Task(String title, String description, TaskStatus status, Priority priority, LocalDateTime dueDate)
  {
    this.title = title;
    this.description = description;
    this.status = status;
    this.priority = priority;
    this.dueDate = dueDate;
  }
}