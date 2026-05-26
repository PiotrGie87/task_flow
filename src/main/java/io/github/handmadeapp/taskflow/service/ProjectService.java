package io.github.handmadeapp.taskflow.service;

import java.time.LocalDateTime;
import java.util.List;

import io.github.handmadeapp.taskflow.entity.Project;
import io.github.handmadeapp.taskflow.enums.ProjectStatus;

public interface ProjectService
{
  List<Project> findAll();

  Project findById(Long id);

  Project save(Project project);

  void deleteById(Long id);

  List<Project> findByStatus(ProjectStatus status);

  List<Project> findByNameContaining(String keyword);

  List<Project> findByDueDateBefore(LocalDateTime date);

  List<Project> findByDueDateAfter(LocalDateTime date);
}
