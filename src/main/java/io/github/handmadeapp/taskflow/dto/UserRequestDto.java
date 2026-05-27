
package io.github.handmadeapp.taskflow.dto;

import io.github.handmadeapp.taskflow.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto
{
  @NotBlank
  private String username;

  @NotBlank
  @Email
  private String email;

  private Role role;

  //TODO consider which fields should be in the request



}