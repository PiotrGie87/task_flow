package io.github.handmadeapp.taskflow.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequestDto
{
  private String username;

  private String email;

  private Boolean enabled;
}