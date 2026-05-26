
package io.github.handmadeapp.taskflow.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import io.github.handmadeapp.taskflow.entity.Project;
import io.github.handmadeapp.taskflow.enums.ProjectStatus;
import io.github.handmadeapp.taskflow.repository.ProjectRepository;
import io.github.handmadeapp.taskflow.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService
{
  private final ProjectRepository projectRepository;

  @Override
  public List<Project> findAll()
  {
    return List.of();
  }

  @Override
  public Project findById(Long id)
  {
    return null;
  }

  @Override
  public Project save(Project project)
  {
    return null;
  }

  @Override
  public void deleteById(Long id)
  {

  }

  @Override
  public List<Project> findByStatus(ProjectStatus status)
  {
    return List.of();
  }

  @Override
  public List<Project> findByNameContaining(String keyword)
  {
    return List.of();
  }

  @Override
  public List<Project> findByDueDateBefore(LocalDateTime date)
  {
    return List.of();
  }

  @Override
  public List<Project> findByDueDateAfter(LocalDateTime date)
  {
    return List.of();
  }
}