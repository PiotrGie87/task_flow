package io.github.handmadeapp.taskflow.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponseDto
{
  private String token;
  private String tokenType;
}