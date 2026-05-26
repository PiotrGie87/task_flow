package io.github.handmadeapp.taskflow.service;

import java.util.List;
import java.util.Optional;

import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Role;

public interface UserService
{
  User findUserById(Long userId);

  User saveUser(User user);

  void deleteUser(Long userId);

  List<User> findAll();

  Optional<User> findByEmail(String userEmail);

  Optional<User> findByName(String userName);

  List<User> findByRole(Role userRole);

  List<User> findByEnabled(boolean isEnabled);
}
