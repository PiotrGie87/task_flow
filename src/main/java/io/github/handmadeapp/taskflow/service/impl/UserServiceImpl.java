
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;
import java.util.Optional;

import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Role;
import io.github.handmadeapp.taskflow.repository.UserRepository;
import io.github.handmadeapp.taskflow.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  @Override
  public User findUserById(Long userId)
  {
    return null;
  }

  @Override
  public User saveUser(User user)
  {
    return null;
  }

  @Override
  public void deleteUser(Long userId)
  {

  }

  @Override
  public List<User> findAll()
  {
    return List.of();
  }

  @Override
  public Optional<User> findByEmail(String userEmail)
  {
    return Optional.empty();
  }

  @Override
  public Optional<User> findByName(String userName)
  {
    return Optional.empty();
  }

  @Override
  public List<User> findByRole(Role userRole)
  {
    return List.of();
  }

  @Override
  public List<User> findByEnabled(boolean isEnabled)
  {
    return List.of();
  }
}