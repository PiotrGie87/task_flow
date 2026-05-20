
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Role;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
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

  @NotFound
  private boolean enabled;

  @CreationTimestamp
  private LocalDateTime ctreatedAt;


}