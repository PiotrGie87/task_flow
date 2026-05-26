package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.github.handmadeapp.taskflow.enums.Role;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String username;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  private boolean enabled;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "user", //refers to "user" property in the Task class
   cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})  //DO NOT APPLY CASCADING DELETES!
  private List<Task> tasks;

  @OneToMany(mappedBy = "user", //refers to "user" property in the Task class
   cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
   fetch = FetchType.LAZY)  //DO NOT APPLY CASCADING DELETES!
  private List<Comment> comments;

  public User(String username, String email, String password, Role role, boolean enabled)
  {
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
    this.enabled = enabled;
  }

  //temporary method. TODO move it to the proper layer
  public void addTask(Task task)
  {

    if (tasks == null) tasks = new ArrayList<>();

    tasks.add(task);
    task.setUser(this);
  }
}