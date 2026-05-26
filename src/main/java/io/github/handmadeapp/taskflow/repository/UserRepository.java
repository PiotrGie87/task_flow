
package io.github.handmadeapp.taskflow.repository;

import java.util.List;
import java.util.Optional;

import io.github.handmadeapp.taskflow.entity.User;
import io.github.handmadeapp.taskflow.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

  List<User> findByRole(Role role);

  List<User> findByEnabled(boolean enabled);
}