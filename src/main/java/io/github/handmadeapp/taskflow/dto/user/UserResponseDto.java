package io.github.handmadeapp.taskflow.dto.user;

import java.time.LocalDateTime;

import io.github.handmadeapp.taskflow.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto
{
  private Long id;
  private String username;
  private String email;
  private Role role;
  private boolean enabled;
  private LocalDateTime createdAt;
}