
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;
import java.util.Optional;

import io.github.handmadeapp.taskflow.dto.user.RegisterUserRequestDto;
import io.github.handmadeapp.taskflow.dto.user.UserResponseDto;
import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Role;
import io.github.handmadeapp.taskflow.exception.UserNotFoundException;
import io.github.handmadeapp.taskflow.mapper.UserMapper;
import io.github.handmadeapp.taskflow.repository.UserRepository;
import io.github.handmadeapp.taskflow.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService
{
  //TODO finish all the methods / remember about authentication

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponseDto findUserById(Long userId)
  {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
    return UserMapper.toUserResponse(user);
  }

  @Override
  public UserResponseDto createUser(RegisterUserRequestDto requestDto)
  {
    return null;
  }

  @Override
  public void deleteUser(Long userId)
  {

  }

  @Override
  public List<UserResponseDto> findAll()
  {
    return List.of();
  }

  @Override
  public Optional<UserResponseDto> findByEmail(String userEmail)
  {
    return Optional.empty();
  }

  @Override
  public Optional<UserResponseDto> findByName(String userName)
  {
    return Optional.empty();
  }

  @Override
  public List<UserResponseDto> findByRole(Role userRole)
  {
    return List.of();
  }

  @Override
  public List<UserResponseDto> findByEnabled(boolean isEnabled)
  {
    return List.of();
  }
}