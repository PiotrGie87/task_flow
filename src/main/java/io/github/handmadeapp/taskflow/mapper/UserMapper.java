package io.github.handmadeapp.taskflow.mapper;

import io.github.handmadeapp.taskflow.dto.user.RegisterUserRequestDto;
import io.github.handmadeapp.taskflow.dto.user.UserResponseDto;
import io.github.handmadeapp.taskflow.entity.User;

public class UserMapper
{
  private UserMapper()
  {

  }

  public static User toEntity(RegisterUserRequestDto requestDto)
  {
    User user = new User();

    user.setUsername(requestDto.getUsername());
    user.setEmail(requestDto.getEmail());

    return user;
  }

  public static UserResponseDto toUserResponse(User user)
  {
    return UserResponseDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .role(user.getRole())
            .enabled(user.isEnabled())
            .createdAt(user.getCreatedAt())
            .build();
  }
}