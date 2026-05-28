package io.github.handmadeapp.taskflow.service;

import java.util.List;
import java.util.Optional;

import io.github.handmadeapp.taskflow.dto.user.RegisterUserRequestDto;
import io.github.handmadeapp.taskflow.dto.user.UserResponseDto;
import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Role;

public interface UserService
{
  UserResponseDto findUserById(Long userId);

  UserResponseDto createUser(RegisterUserRequestDto requestDto);

  void deleteUser(Long userId);

  List<UserResponseDto> findAll();

  Optional<UserResponseDto> findByEmail(String userEmail);

  Optional<UserResponseDto> findByName(String userName);

  List<UserResponseDto> findByRole(Role userRole);

  List<UserResponseDto> findByEnabled(boolean isEnabled);
}
