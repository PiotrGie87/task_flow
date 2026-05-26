
package io.github.handmadeapp.taskflow.repository;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Task;
import io.github.handmadeapp.taskflow.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>
{
  List<Task> findByStatus(TaskStatus status);
  List<Task> findByUserId(Long userId);
  List<Task> findByProject(Long projectId);
}